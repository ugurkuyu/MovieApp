package com.ugurkuyu.movieapp.viewmodel

import androidx.core.text.HtmlCompat
import com.ugurkuyu.movieapp.model.remote.toprated.TopRatedMovies

class TopRatedMoviesItemViewModel(private val topRatedMovies: TopRatedMovies) {
    val movieName: String get() = topRatedMovies.title

    val moviePoster: String get() = topRatedMovies.posterPath!!

    val releaseDate: String get() = topRatedMovies.releaseDate.take(4)

    //val genre: List<Int> get() = topRatedMovies.genreIds

    val releaseDateGenreText: String
        get() = "$releaseDate " + HtmlCompat.fromHtml(
            "&#x2022",
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )

    val rating: Float get() = topRatedMovies.voteAverage.toFloat()

    val ratingFloat: Float get() = topRatedMovies.voteAverage.toFloat() / 2f

    val ratingText: String get() = rating.toString()
}