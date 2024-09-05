package com.aamaulana10.moviecompose.feature.home.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.aamaulana10.moviecompose.feature.home.core.di.HomeInjection
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.utils.network.ApiResponse

class DetailViewModel(private val movieId: String) {
    private var useCase = HomeInjection().provideHomeUseCase()

    var movie = MutableLiveData<MovieVideosModel>()

    init {
        getDetailMovies()
    }

    private fun getDetailMovies() {
        useCase.getMovieDetail(movieId).asLiveData().observeForever { response ->
            when (response) {
                is ApiResponse.Success -> {
                    movie.value = response.data
                    println("Success get detail ${response.data}")
                }

                is ApiResponse.Empty -> {}
                is ApiResponse.Error -> {}
            }
        }
    }

}