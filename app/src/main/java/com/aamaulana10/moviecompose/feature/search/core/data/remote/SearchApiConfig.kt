package com.aamaulana10.moviecompose.feature.search.core.data.remote

import com.aamaulana10.moviecompose.utils.RetrofitHelper

object SearchApiConfig {

    private const val baseUrl = "https://api.themoviedb.org/"

    fun provideApiService(): SearchService {
        return RetrofitHelper.createService(baseUrl).create(SearchService::class.java)
    }
}