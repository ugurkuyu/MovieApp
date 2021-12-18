package com.ugurkuyu.movieapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.PagerSnapHelper
import com.ugurkuyu.movieapp.R
import com.ugurkuyu.movieapp.adapters.LatestMoviesAdapter
import com.ugurkuyu.movieapp.adapters.PopularMoviesAdapter
import com.ugurkuyu.movieapp.adapters.TopRatedMoviesAdapter
import com.ugurkuyu.movieapp.adapters.UpcomingMoviesAdapter
import com.ugurkuyu.movieapp.databinding.ActivityHomePageBinding
import com.ugurkuyu.movieapp.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    private lateinit var latestMoviesAdapter: LatestMoviesAdapter
    private lateinit var popularMoviesAdapter: PopularMoviesAdapter
    private lateinit var topRatedMoviesAdapter: TopRatedMoviesAdapter
    private lateinit var upcomingMoviesAdapter: UpcomingMoviesAdapter

    val viewModel by viewModels<HomePageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_page)

        binding.viewModel = viewModel

        val snapHelper = PagerSnapHelper()

        viewModel.latestMoviesLiveData.observe(this, {
            latestMoviesAdapter = LatestMoviesAdapter(it)
            binding.recyclerViewLatest.adapter = latestMoviesAdapter
        })

        viewModel.popularMoviesLiveData.observe(this, {
            popularMoviesAdapter = PopularMoviesAdapter(it)
            binding.recyclerViewPopular.adapter = popularMoviesAdapter
        })

        viewModel.topRatedMoviesLiveData.observe(this, {
            topRatedMoviesAdapter = TopRatedMoviesAdapter(it)
            binding.recyclerViewTopRated.adapter = topRatedMoviesAdapter
        })

        viewModel.upcomingMoviesLiveData.observe(this, {
            upcomingMoviesAdapter = UpcomingMoviesAdapter(it)
            binding.recyclerViewUpcoming.adapter = upcomingMoviesAdapter
        })

        snapHelper.attachToRecyclerView(binding.recyclerViewUpcoming)
    }
}