package com.ugurkuyu.movieapp.viewmodel

import com.ugurkuyu.movieapp.model.remote.popular.PopularMovies

class PopularMoviesItemViewModel(private val popularMovies: PopularMovies) {
    val movieName: String get() = popularMovies.title

    val moviePoster: String get() = popularMovies.posterPath!!
}