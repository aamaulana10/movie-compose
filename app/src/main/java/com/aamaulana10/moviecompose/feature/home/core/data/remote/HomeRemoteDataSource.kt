package com.aamaulana10.moviecompose.feature.home.core.data.remote

import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.utils.network.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HomeRemoteDataSource(private val service: HomeService) {

    fun getPopularMovies(): Flow<ApiResponse<List<MovieVideosModel>>> {
        println("call this functionnnn")
        return flow {

            try {

                val response = service.getPopularMovies()
                println("response $response")
                val dataArray = response.results
                println("result ${response.results}")
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                println("RemoteDataSource, $e")
                emit(ApiResponse.Error(e.toString()))
            }

        }.flowOn(Dispatchers.IO)
    }
}