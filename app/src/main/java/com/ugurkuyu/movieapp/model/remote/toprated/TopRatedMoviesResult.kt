package com.ugurkuyu.movieapp.model.remote.toprated


import com.google.gson.annotations.SerializedName

data class TopRatedMoviesResult(
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("results")
    val results: List<TopRatedMovies> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("total_results")
    val totalResults: Int = 0
)