package com.an.moviesample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.an.moviesample.R;
import com.an.moviesample.adapter.MovieListAdapter;
import com.an.moviesample.databinding.MainActivityBinding;
import com.an.moviesample.model.Movie;
import com.an.moviesample.view.recyclerview.RecyclerItemClickListener;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

public class MainActivity extends AppCompatActivity implements RecyclerItemClickListener.OnRecyclerViewItemClickListener {

    static {
        System.loadLibrary("MovieController");
    }


    private MainActivityBinding binding;
    private MovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialiseView();
    }

    private void initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        movieListAdapter = new MovieListAdapter(getApplicationContext(), getMovies());
        binding.recyclerView.setAdapter(movieListAdapter);
        binding.recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), this));
    }


    public native ArrayList<Movie> getMovies();

    @Override
    public void onItemClick(View parentView, View childView, int position) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<>(childView.findViewById(R.id.item_img), getString(R.string.transition_image)),
                new Pair<>(childView.findViewById(R.id.item_title), getString(R.string.transition_title)));

        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("movie", movieListAdapter.getItem(position));
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
