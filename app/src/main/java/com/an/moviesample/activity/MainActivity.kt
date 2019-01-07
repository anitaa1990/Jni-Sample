package com.an.moviesample.activity

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.an.moviesample.R
import com.an.moviesample.adapter.MovieListAdapter
import com.an.moviesample.databinding.MainActivityBinding
import com.an.moviesample.model.Movie

import java.util.ArrayList
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.an.moviesample.view.recyclerview.RecyclerItemClickListener

class MainActivity : AppCompatActivity(), RecyclerItemClickListener.OnRecyclerViewItemClickListener {


    private lateinit var binding: MainActivityBinding
    private lateinit var movieListAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
    }

    private fun initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        movieListAdapter = MovieListAdapter(applicationContext, getMovies())
        binding.recyclerView.adapter = movieListAdapter
        binding.recyclerView.addOnItemTouchListener(RecyclerItemClickListener(applicationContext, this))
    }

    override fun onItemClick(parentView: View, childView: View, position: Int) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                Pair(childView.findViewById(R.id.item_img), getString(R.string.transition_image)),
                Pair(childView.findViewById(R.id.item_title), getString(R.string.transition_title)))

        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("movie", movieListAdapter.getItem(position))
        ActivityCompat.startActivity(this, intent, options.toBundle())
    }


    @Throws(IllegalArgumentException::class)
    external fun getMovies(): ArrayList<Movie>

    companion object {

        init {
            System.loadLibrary("MovieController")
        }
    }
}
