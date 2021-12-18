package com.ugurkuyu.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugurkuyu.movieapp.databinding.RecyclerViewUpcomingItemBinding
import com.ugurkuyu.movieapp.model.remote.upcoming.UpcomingMovies
import com.ugurkuyu.movieapp.viewmodel.UpcomingMoviesItemViewModel

class UpcomingMoviesAdapter(var list: List<UpcomingMovies>) :
        RecyclerView.Adapter<UpcomingMoviesAdapter.UpcomingMoviesAdapterViewHolder>() {
    inner class UpcomingMoviesAdapterViewHolder(private val binding: RecyclerViewUpcomingItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: UpcomingMovies) {
            binding.viewModel = UpcomingMoviesItemViewModel(movie)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): UpcomingMoviesAdapterViewHolder {
        return UpcomingMoviesAdapterViewHolder(
                RecyclerViewUpcomingItemBinding.inflate(
                        LayoutInflater.from(
                                parent.context
                        ), parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: UpcomingMoviesAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}