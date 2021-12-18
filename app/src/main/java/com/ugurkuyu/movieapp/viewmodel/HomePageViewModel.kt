package com.ugurkuyu.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugurkuyu.movieapp.model.remote.latest.LatestMovies
import com.ugurkuyu.movieapp.model.remote.popular.PopularMovies
import com.ugurkuyu.movieapp.model.remote.toprated.TopRatedMovies
import com.ugurkuyu.movieapp.model.remote.upcoming.UpcomingMovies
import com.ugurkuyu.movieapp.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(private var apiService: ApiService) : ViewModel() {

    private var _latestMoviesLiveData = MutableLiveData<List<LatestMovies>>()
    val latestMoviesLiveData get() = _latestMoviesLiveData as LiveData<List<LatestMovies>>

    private var _popularMoviesLiveData = MutableLiveData<List<PopularMovies>>()
    val popularMoviesLiveData get() = _popularMoviesLiveData as LiveData<List<PopularMovies>>

    private var _topRatedMoviesLiveData = MutableLiveData<List<TopRatedMovies>>()
    val topRatedMoviesLiveData get() = _topRatedMoviesLiveData as LiveData<List<TopRatedMovies>>

    private var _upcomingMoviesLiveData = MutableLiveData<List<UpcomingMovies>>()
    val upcomingMoviesLiveData get() = _upcomingMoviesLiveData as LiveData<List<UpcomingMovies>>

    init {
        getLatestMovies()
        getPopularMovies()
        getTopRatedMovies()
        getUpcomingMovies()
    }

    private suspend fun fetchLatestMovies() = flow {
        emit(apiService.getLatestMovies())
    }

    private suspend fun fetchPopularMovies() = flow {
        emit(apiService.getPopularMovies())
    }

    private suspend fun fetchTopRatedMovies() = flow {
        emit(apiService.getTopRatedMovies())
    }

    private suspend fun fetchUpcomingMovies() = flow {
        emit(apiService.getUpcomingMovies())
    }

    private fun getLatestMovies() {
        viewModelScope.launch {
            fetchLatestMovies().collect {
                _latestMoviesLiveData.postValue(it.results)
                it.results.map { it1 -> LatestMoviesItemViewModel(it1) }
            }
        }
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            fetchPopularMovies().collect {
                _popularMoviesLiveData.postValue(it.results)
                it.results.map { it1 -> PopularMoviesItemViewModel(it1) }
            }
        }
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            fetchTopRatedMovies().collect {
                _topRatedMoviesLiveData.postValue(it.results)
                it.results.map { it1 -> TopRatedMoviesItemViewModel(it1) }
            }
        }
    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            fetchUpcomingMovies().collect {
                _upcomingMoviesLiveData.postValue(it.results)
                it.results.map { it1 -> UpcomingMoviesItemViewModel(it1) }
            }
        }
    }
}