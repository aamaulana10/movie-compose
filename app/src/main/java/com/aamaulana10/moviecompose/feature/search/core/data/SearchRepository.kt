package com.aamaulana10.moviecompose.feature.search.core.data

import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.feature.search.core.data.remote.SearchRemoteDataSource
import com.aamaulana10.moviecompose.utils.network.ApiResponse
import kotlinx.coroutines.flow.Flow

interface ISearchRepository {

    fun searchMovies(query: String): Flow<ApiResponse<List<MovieVideosModel>>>
}

class SearchRepository(private val searchRemoteDataSource: SearchRemoteDataSource) :
    ISearchRepository {

    override fun searchMovies(query: String): Flow<ApiResponse<List<MovieVideosModel>>> {
        return searchRemoteDataSource.searchMovies(query)
    }
}