package com.an.moviesample.activity


import android.os.Bundle
import android.widget.Toast

import com.an.moviesample.BuildConfig
import com.an.moviesample.R
import com.an.moviesample.databinding.VideoActivityBinding
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import androidx.databinding.DataBindingUtil

class VideoActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    private lateinit var videoKey: String
    private lateinit var binding: VideoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
    }

    private fun initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video)
        binding.youtubeView.initialize(BuildConfig.YOUTUBE_API_KEY, this)
        videoKey = intent.getStringExtra("video_key")
    }

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider, youTubePlayer: YouTubePlayer, b: Boolean) {
        youTubePlayer.setFullscreen(true)
        youTubePlayer.loadVideo(videoKey) // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider, youTubeInitializationResult: YouTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_REQUEST).show()
        } else {
            val error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString())
            Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
        }
    }

    companion object {

        private val RECOVERY_REQUEST = 1
    }
}
