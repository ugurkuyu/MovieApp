package com.ugurkuyu.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugurkuyu.movieapp.databinding.RecyclerViewPopularItemBinding
import com.ugurkuyu.movieapp.model.remote.popular.PopularMovies
import com.ugurkuyu.movieapp.viewmodel.PopularMoviesItemViewModel

class PopularMoviesAdapter(var list: List<PopularMovies>) :
    RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesAdapterViewHolder>() {
    inner class PopularMoviesAdapterViewHolder(private val binding: RecyclerViewPopularItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: PopularMovies) {
            binding.viewModel = PopularMoviesItemViewModel(movie)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularMoviesAdapterViewHolder {
        return PopularMoviesAdapterViewHolder(
            RecyclerViewPopularItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularMoviesAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}