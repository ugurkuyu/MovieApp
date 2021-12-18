package com.ugurkuyu.movieapp.model.remote.upcoming


import com.google.gson.annotations.SerializedName
import com.ugurkuyu.movieapp.model.remote.Dates

data class UpcomingMoviesResult(
        @SerializedName("dates")
        val dates: Dates = Dates(),
        @SerializedName("page")
        val page: Int = 0,
        @SerializedName("results")
        val results: List<UpcomingMovies> = listOf(),
        @SerializedName("total_pages")
        val totalPages: Int = 0,
        @SerializedName("total_results")
        val totalResults: Int = 0
)