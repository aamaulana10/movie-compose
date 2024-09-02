package com.aamaulana10.moviecompose.feature.home.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.aamaulana10.moviecompose.feature.home.core.di.HomeInjection
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.feature.home.core.domain.usecase.HomeUseCase
import com.aamaulana10.moviecompose.utils.network.ApiResponse

class HomeViewModel() {

    private var useCase = HomeInjection().provideHomeUseCase()

    var popularMovies = MutableLiveData<List<MovieVideosModel>>()

    fun getPopularMovies() {
        useCase.getPopularMovies().asLiveData().observeForever { response ->
            println("response ${response}")
            when (response) {
                is ApiResponse.Success -> {
                    popularMovies.value = response.data
                }
                is ApiResponse.Error -> {
                    popularMovies.value = emptyList()
                }
                is ApiResponse.Empty -> {
                    popularMovies.value = emptyList()
                }
            }

            println("popularMovies ${popularMovies.value}")

        }
    }
}