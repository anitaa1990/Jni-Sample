package com.an.moviesample.activity;


import android.os.Bundle;
import android.widget.Toast;

import com.an.moviesample.BuildConfig;
import com.an.moviesample.R;
import com.an.moviesample.databinding.VideoActivityBinding;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_REQUEST = 1;

    private String videoKey;
    private VideoActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialiseView();
    }

    private void initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video);
        binding.youtubeView.initialize(BuildConfig.YOUTUBE_API_KEY, this);
        videoKey = getIntent().getStringExtra("video_key");
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setFullscreen(true);
        youTubePlayer.loadVideo(videoKey); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }
}
