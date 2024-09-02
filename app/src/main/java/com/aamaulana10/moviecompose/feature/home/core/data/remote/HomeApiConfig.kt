package com.aamaulana10.moviecompose.feature.home.core.data.remote

import com.aamaulana10.moviecompose.utils.RetrofitHelper

object HomeApiConfig {

        private const val baseUrl = "https://api.themoviedb.org/"

        fun provideApiService(): HomeService {
            return RetrofitHelper.createService(baseUrl).create(HomeService::class.java)
        }
}