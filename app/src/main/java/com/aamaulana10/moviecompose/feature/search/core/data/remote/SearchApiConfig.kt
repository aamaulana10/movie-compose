package com.aamaulana10.moviecompose.feature.search.core.data.remote

import com.aamaulana10.moviecompose.utils.RetrofitHelper

object SearchApiConfig {

    private const val BASE_URL = "https://api.themoviedb.org/"

    fun provideApiService(): SearchService {
        return RetrofitHelper.createService(BASE_URL).create(SearchService::class.java)
    }
}