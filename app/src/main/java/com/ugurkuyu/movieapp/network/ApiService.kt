package com.ugurkuyu.movieapp.network

import com.ugurkuyu.movieapp.model.remote.LatestMovies
import com.ugurkuyu.movieapp.util.Constants
import com.ugurkuyu.movieapp.util.Resource
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("movie/latest?api_key=" + Constants.API_KEY)
    suspend fun getLatestMovies(): Response<Resource<List<LatestMovies>>>
}