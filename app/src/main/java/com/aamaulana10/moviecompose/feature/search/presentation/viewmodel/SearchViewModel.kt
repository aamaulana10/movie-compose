package com.aamaulana10.moviecompose.feature.search.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.feature.search.core.di.SearchInjection
import com.aamaulana10.moviecompose.utils.network.ApiResponse

class SearchViewModel {

    private var useCase = SearchInjection().provideSearchUseCase()

    var movies = MutableLiveData<List<MovieVideosModel>>()

    fun searchVideos(query: String) {
        useCase.searchMovies(query).asLiveData().observeForever { response ->
            when (response) {
                is ApiResponse.Success -> {
                    movies.value = response.data
                }

                is ApiResponse.Error -> {
                    movies.value = emptyList()
                }

                is ApiResponse.Empty -> {
                    movies.value = emptyList()
                }
            }
        }
    }
}