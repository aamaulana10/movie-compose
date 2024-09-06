package com.aamaulana10.moviecompose.feature.home.core.data.remote

import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.utils.network.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HomeRemoteDataSource(private val service: HomeService) {

    fun getPopularMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        return flow {
            try {
                val response = service.getPopularMovies()
                val dataArray = response.results

                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getUpcomingMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        return flow {
            try {
                val response = service.getUpcomingMovies()
                val dataArray = response.results

                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getNowPlayingMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        return flow {
            try {
                val response = service.getNowPlayingMovies()
                val dataArray = response.results

                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getMovieDetail(movieId: String): Flow<ApiResponse<MovieVideosModel>> {
        return flow {
            try {
                val response = service.getMovieDetail(movieId)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {

                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}