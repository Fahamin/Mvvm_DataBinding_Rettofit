package com.sari.shopping.mvvmwithrettofit.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sari.shopping.mvvmwithrettofit.databinding.ItemlayoutBinding;
import com.sari.shopping.mvvmwithrettofit.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<Movie> list;

    public MovieAdapter(List<Movie> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemlayoutBinding itemlayoutBinding = ItemlayoutBinding.inflate(inflater,parent,false);
        return new MovieViewHolder(itemlayoutBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie =list.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        // If your layout file is something_awesome.xml then your binding class will be SomethingAwesomeBinding
        // Since our layout file is item_movie.xml, our auto generated binding class is ItemMovieBinding

        private ItemlayoutBinding binding;

        public MovieViewHolder(ItemlayoutBinding  binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Movie movie)
        {
            binding.setModel(movie);
            binding.executePendingBindings();
        }
    }
}
