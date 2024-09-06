package com.aamaulana10.moviecompose.feature.search.core.domain.usecase

import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.feature.search.core.data.ISearchRepository
import com.aamaulana10.moviecompose.utils.network.ApiResponse
import kotlinx.coroutines.flow.Flow

interface ISearchUseCase {
    fun searchMovies(query: String): Flow<ApiResponse<List<MovieVideosModel>>>
}

class SearchUseCase(private val repository: ISearchRepository) : ISearchUseCase {

    override fun searchMovies(query: String): Flow<ApiResponse<List<MovieVideosModel>>> {
        return repository.searchMovies(query)
    }
}