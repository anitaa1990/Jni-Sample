package com.an.moviesample.activity

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.an.moviesample.R
import com.an.moviesample.adapter.VideoListAdapter
import com.an.moviesample.databinding.DetailActivityBinding
import com.an.moviesample.model.Movie
import com.bumptech.glide.Glide

import java.util.Arrays
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.an.moviesample.view.recyclerview.RecyclerItemClickListener

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
    }

    private fun initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val movie = intent.getSerializableExtra("movie") as Movie
        Glide.with(this).load(movie.posterUrl).into(binding.image)
        binding.movieTitle.text = movie.name
        binding.movieDesc.text = movie.description
        binding.movieStatus.items = Arrays.asList(movie.status)
        binding.collectionItemPicker.isUseRandomColor = true
        binding.collectionItemPicker.items = movie.getGenreList()
        binding.txtRuntime.text = String.format("%s mins", movie.runtime.toString())

        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.smoothScrollToPosition(1)
        val videoListAdapter = VideoListAdapter(applicationContext, movie.getVideoList())
        binding.recyclerView.adapter = videoListAdapter
        binding.recyclerView.addOnItemTouchListener(
                RecyclerItemClickListener(applicationContext, object : RecyclerItemClickListener.OnRecyclerViewItemClickListener {
                    override fun onItemClick(parentView: View, childView: View, position: Int) {
                        val intent = Intent(applicationContext, VideoActivity::class.java)
                        intent.putExtra("video_key", videoListAdapter.getItem(position))
                        startActivity(intent)
                    }
                })
        )
    }
}
