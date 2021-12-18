package com.ugurkuyu.movieapp.network

import com.ugurkuyu.movieapp.model.remote.latest.LatestMoviesResult
import com.ugurkuyu.movieapp.model.remote.popular.PopularMoviesResult
import com.ugurkuyu.movieapp.model.remote.toprated.TopRatedMoviesResult
import com.ugurkuyu.movieapp.model.remote.upcoming.UpcomingMoviesResult
import com.ugurkuyu.movieapp.util.Constants
import retrofit2.http.GET

interface ApiService {

    @GET("movie/now_playing?api_key=" + Constants.API_KEY)
    suspend fun getLatestMovies(): LatestMoviesResult

    @GET("movie/popular?api_key=" + Constants.API_KEY)
    suspend fun getPopularMovies(): PopularMoviesResult

    @GET("movie/top_rated?api_key=" + Constants.API_KEY)
    suspend fun getTopRatedMovies(): TopRatedMoviesResult

    @GET("movie/upcoming?api_key=" + Constants.API_KEY)
    suspend fun getUpcomingMovies(): UpcomingMoviesResult
}