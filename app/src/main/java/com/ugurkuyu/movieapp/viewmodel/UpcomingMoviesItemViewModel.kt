package com.ugurkuyu.movieapp.viewmodel

import com.ugurkuyu.movieapp.model.remote.upcoming.UpcomingMovies

class UpcomingMoviesItemViewModel(private val upcomingMovies: UpcomingMovies) {
    val movieName: String get() = upcomingMovies.title

    val moviePoster: String? get() = upcomingMovies.backdropPath

    val releaseDate: String get() = upcomingMovies.releaseDate
}