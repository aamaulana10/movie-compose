package com.aamaulana10.moviecompose.feature.home.core.domain.usecase

import com.aamaulana10.moviecompose.feature.home.core.data.IHomeRepository
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.utils.network.ApiResponse
import kotlinx.coroutines.flow.Flow

interface IHomeUseCase {
    fun getPopularMovies(): Flow<ApiResponse<List<MovieVideosModel>>>
    fun getUpcomingMovies(): Flow<ApiResponse<List<MovieVideosModel>>>
    fun getNowPlayingMovies(): Flow<ApiResponse<List<MovieVideosModel>>>
    fun getMovieDetail(movieId: String): Flow<ApiResponse<MovieVideosModel>>
}

class HomeUseCase(private val repository: IHomeRepository) : IHomeUseCase {

    override fun getPopularMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        return repository.getPopularMovies()
    }

    override fun getUpcomingMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        return repository.getUpcomingMovies()
    }

    override fun getNowPlayingMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        return repository.getNowPlayingMovies()
    }

    override fun getMovieDetail(movieId: String): Flow<ApiResponse<MovieVideosModel>> {
        return repository.getMovieDetail(movieId)
    }

}