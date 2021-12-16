package com.ugurkuyu.movieapp.model.remote.latest


import com.google.gson.annotations.SerializedName

data class LatestMoviesResult(
    @SerializedName("dates")
    val dates: Dates = Dates(),
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("results")
    val results: List<LatestMovies> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("total_results")
    val totalResults: Int = 0
)