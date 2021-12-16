package com.ugurkuyu.movieapp.viewmodel

import com.ugurkuyu.movieapp.model.remote.latest.LatestMovies

class LatestMoviesItemViewModel(private val latestMovies: LatestMovies) {
    val movieName: String get() = latestMovies.title

    val moviePoster: String get() = latestMovies.posterPath!!
}