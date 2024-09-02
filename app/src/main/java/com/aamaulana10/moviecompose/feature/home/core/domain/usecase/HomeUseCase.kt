package com.aamaulana10.moviecompose.feature.home.core.domain.usecase

import com.aamaulana10.moviecompose.feature.home.core.data.IHomeRepository
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.utils.network.ApiResponse
import kotlinx.coroutines.flow.Flow

interface IHomeUseCase {
    fun getPopularMovies(): Flow<ApiResponse<List<MovieVideosModel>>>
}

class HomeUseCase(private val repository: IHomeRepository): IHomeUseCase  {

    override fun getPopularMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        return repository.getPopularMovies()
    }

}