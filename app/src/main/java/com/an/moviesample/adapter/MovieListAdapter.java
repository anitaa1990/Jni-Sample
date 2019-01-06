package com.an.moviesample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.an.moviesample.model.Movie;
import com.an.moviesample.databinding.MovieListItemBinding;
import com.bumptech.glide.Glide;
import com.github.florent37.glidepalette.BitmapPalette;
import com.github.florent37.glidepalette.GlidePalette;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.CustomViewHolder> {

    private Context context;
    private List<Movie> movies;
    public MovieListAdapter(Context context,
                            List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MovieListItemBinding itemBinding = MovieListItemBinding.inflate(layoutInflater, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(itemBinding);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindTo(getItem(position));
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }

    public Movie getItem(int position) {
        return movies.get(position);
    }

    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private MovieListItemBinding binding;
        public CustomViewHolder(MovieListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(Movie movie) {
            binding.itemTitle.setText(movie.getName());
            Glide.with(context)
                    .load(movie.getPosterUrl())
                    .listener(GlidePalette.with(movie.getPosterUrl())
                            .use(BitmapPalette.Profile.VIBRANT)
                            .intoBackground(binding.itemPalette)
                            .crossfade(true))
                    .into(binding.itemImg);
        }
    }
}
