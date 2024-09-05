package com.aamaulana10.moviecompose.feature.home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.aamaulana10.moviecompose.feature.home.core.di.HomeInjection
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.utils.network.ApiResponse

class HomeViewModel {

    private var useCase = HomeInjection().provideHomeUseCase()

    var movies = MutableLiveData<List<MovieVideosModel>>()
    var popularMovies = MutableLiveData<List<MovieVideosModel>>()
    var nowPlayingMovies = MutableLiveData<List<MovieVideosModel>>()
    var upcomingMovies = MutableLiveData<List<MovieVideosModel>>()
    val categories = listOf("All", "Popular", "Now Playing", "Top Rated", "Upcoming")
    var selectedCategory by mutableStateOf("All")

    init {
        getAllVideosWithCategory()
    }

    private fun getAllVideosWithCategory() {
        getPopularMovies()
        getUpcomingMovies()
        getNowPlayingMovies()
    }

    private fun getPopularMovies() {
        useCase.getPopularMovies().asLiveData().observeForever { response ->
            when (response) {
                is ApiResponse.Success -> {
                    movies.value = response.data
                    popularMovies.value = response.data
                }

                is ApiResponse.Error -> {
                    movies.value = emptyList()
                    popularMovies.value = emptyList()
                }

                is ApiResponse.Empty -> {
                    movies.value = emptyList()
                    popularMovies.value = emptyList()
                }
            }
        }
    }

    private fun getUpcomingMovies() {
        useCase.getUpcomingMovies().asLiveData().observeForever { response ->
            when (response) {
                is ApiResponse.Success -> {
                    movies.value = response.data
                    upcomingMovies.value = response.data
                }

                is ApiResponse.Error -> {
                    movies.value = emptyList()
                    upcomingMovies.value = emptyList()
                }

                is ApiResponse.Empty -> {
                    movies.value = emptyList()
                    upcomingMovies.value = emptyList()
                }
            }
        }
    }

    private fun getNowPlayingMovies() {
        useCase.getNowPlayingMovies().asLiveData().observeForever { response ->
            when (response) {
                is ApiResponse.Success -> {
                    movies.value = response.data
                    nowPlayingMovies.value = response.data
                }

                is ApiResponse.Error -> {
                    movies.value = emptyList()
                    nowPlayingMovies.value = emptyList()
                }

                is ApiResponse.Empty -> {
                    movies.value = emptyList()
                    nowPlayingMovies.value = emptyList()
                }
            }
        }
    }

    fun updateCategory(category: String) {
        selectedCategory = category
        movies.value = emptyList()
        if (selectedCategory == "All") {
            getAllVideosWithCategory()
        }
        if (selectedCategory == "Popular") {
            getPopularMovies()
        }
        if (selectedCategory == "Upcoming") {
            getUpcomingMovies()
        }
        if (selectedCategory == "Now Playing") {
            getNowPlayingMovies()
        }
    }

}