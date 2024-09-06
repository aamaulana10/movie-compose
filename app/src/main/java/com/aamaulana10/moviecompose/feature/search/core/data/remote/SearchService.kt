package com.aamaulana10.moviecompose.feature.search.core.data.remote

import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("3/search/movie?api_key=5497119fe607a02621a85d7e0e376fcd&language=en-US")
    suspend fun searchMovies(@Query("query") query: String): MovieVideosResponse
}