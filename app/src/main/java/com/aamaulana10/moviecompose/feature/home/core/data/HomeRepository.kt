package com.aamaulana10.moviecompose.feature.home.core.data

import com.aamaulana10.moviecompose.feature.home.core.data.remote.HomeRemoteDataSource
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.utils.network.ApiResponse
import kotlinx.coroutines.flow.Flow

interface IHomeRepository {

    fun getPopularMovies(): Flow<ApiResponse<List<MovieVideosModel>>>
    fun getUpcomingMovies(): Flow<ApiResponse<List<MovieVideosModel>>>
    fun getNowPlayingMovies(): Flow<ApiResponse<List<MovieVideosModel>>>
    fun getMovieDetail(movieId: String): Flow<ApiResponse<MovieVideosModel>>
}

class HomeRepository(private val homeRemoteDataSource: HomeRemoteDataSource) : IHomeRepository {

    override fun getPopularMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        return homeRemoteDataSource.getPopularMovies()
    }

    override fun getUpcomingMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        return homeRemoteDataSource.getUpcomingMovies()
    }

    override fun getNowPlayingMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        return homeRemoteDataSource.getNowPlayingMovies()
    }

    override fun getMovieDetail(movieId: String): Flow<ApiResponse<MovieVideosModel>> {
        return homeRemoteDataSource.getMovieDetail(movieId)
    }
}