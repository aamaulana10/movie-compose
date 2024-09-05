package com.aamaulana10.moviecompose.feature.home.core.data.remote

import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {

    @GET("3/movie/popular?api_key=5497119fe607a02621a85d7e0e376fcd&language=en-US")
    suspend fun getPopularMovies(): MovieVideosResponse

    @GET("3/movie/upcoming?api_key=5497119fe607a02621a85d7e0e376fcd&language=en-US")
    suspend fun getUpcomingMovies(): MovieVideosResponse

    @GET("3/movie/top_rated?api_key=5497119fe607a02621a85d7e0e376fcd&language=en-US")
    suspend fun getNowPlayingMovies(): MovieVideosResponse

    @GET("3/movie/{movie_id}?api_key=5497119fe607a02621a85d7e0e376fcd&language=en-US")
    suspend fun getMovieDetail(@Path("movie_id") id: String): MovieVideosModel
}