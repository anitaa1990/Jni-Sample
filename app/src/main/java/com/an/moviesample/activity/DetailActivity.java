package com.an.moviesample.activity;

import android.content.Intent;
import android.os.Bundle;

import com.an.moviesample.R;
import com.an.moviesample.adapter.VideoListAdapter;
import com.an.moviesample.databinding.DetailActivityBinding;
import com.an.moviesample.model.Movie;
import com.an.moviesample.view.recyclerview.RecyclerItemClickListener;
import com.bumptech.glide.Glide;

import java.util.Arrays;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

public class DetailActivity extends AppCompatActivity {

    private DetailActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialiseView();
    }

    private void initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");
        Glide.with(this).load(movie.getPosterUrl()).into(binding.image);
        binding.movieTitle.setText(movie.getName());
        binding.movieDesc.setText(movie.getDescription());
        binding.movieStatus.setItems(Arrays.asList(new String[]{ movie.getStatus() }));
        binding.collectionItemPicker.setUseRandomColor(true);
        binding.collectionItemPicker.setItems(movie.getGenreList());
        binding.txtRuntime.setText(String.format("%s mins", String.valueOf(movie.getRuntime())));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.smoothScrollToPosition(1);
        VideoListAdapter videoListAdapter = new VideoListAdapter(getApplicationContext(), movie.getVideoList());
        binding.recyclerView.setAdapter(videoListAdapter);
        binding.recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, (parentView, childView, position) -> {
            Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
            intent.putExtra("video_key", videoListAdapter.getItem(position));
            startActivity(intent);
        }));
    }
}
