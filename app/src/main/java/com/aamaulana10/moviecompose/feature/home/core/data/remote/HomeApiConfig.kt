package com.aamaulana10.moviecompose.feature.home.core.data.remote

import com.aamaulana10.moviecompose.utils.RetrofitHelper

object HomeApiConfig {

    private const val BASE_URL = "https://api.themoviedb.org/"

    fun provideApiService(): HomeService {
        return RetrofitHelper.createService(BASE_URL).create(HomeService::class.java)
    }
}