package com.ugurkuyu.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugurkuyu.movieapp.databinding.RecyclerViewTopRatedItemBinding
import com.ugurkuyu.movieapp.model.remote.toprated.TopRatedMovies
import com.ugurkuyu.movieapp.viewmodel.TopRatedMoviesItemViewModel

class TopRatedMoviesAdapter(var list: List<TopRatedMovies>) :
    RecyclerView.Adapter<TopRatedMoviesAdapter.TopRatedMoviesAdapterViewHolder>() {
    inner class TopRatedMoviesAdapterViewHolder(private val binding: RecyclerViewTopRatedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: TopRatedMovies) {
            binding.viewModel = TopRatedMoviesItemViewModel(movie)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopRatedMoviesAdapterViewHolder {
        return TopRatedMoviesAdapterViewHolder(
            RecyclerViewTopRatedItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TopRatedMoviesAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}