package com.an.moviesample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.an.moviesample.model.Movie
import com.an.moviesample.databinding.MovieListItemBinding
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import androidx.recyclerview.widget.RecyclerView

class MovieListAdapter(private val context: Context,
                       private val movies: List<Movie>) : RecyclerView.Adapter<MovieListAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = MovieListItemBinding.inflate(layoutInflater, parent, false)
        return CustomViewHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    fun getItem(position: Int): Movie {
        return movies[position]
    }

    inner class CustomViewHolder(private val binding: MovieListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(movie: Movie) {
            binding.itemTitle.text = movie.name
            Glide.with(context)
                    .load(movie.posterUrl)
                    .listener(GlidePalette.with(movie.posterUrl)
                            .use(BitmapPalette.Profile.VIBRANT)
                            .intoBackground(binding.itemPalette)
                            .crossfade(true))
                    .into(binding.itemImg)
        }
    }
}
