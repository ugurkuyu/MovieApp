package com.ugurkuyu.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugurkuyu.movieapp.databinding.RecyclerViewLatestItemBinding
import com.ugurkuyu.movieapp.model.remote.latest.LatestMovies
import com.ugurkuyu.movieapp.viewmodel.LatestMoviesItemViewModel

class LatestMoviesAdapter(var latestMoviesList: List<LatestMovies>) :
    RecyclerView.Adapter<LatestMoviesAdapter.HomePageViewHolder>() {

    inner class HomePageViewHolder(private val binding: RecyclerViewLatestItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: LatestMovies) {
            binding.viewModel = LatestMoviesItemViewModel(movie)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        return HomePageViewHolder(
            RecyclerViewLatestItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        holder.bind(latestMoviesList[position])
    }

    override fun getItemCount(): Int = latestMoviesList.size
}