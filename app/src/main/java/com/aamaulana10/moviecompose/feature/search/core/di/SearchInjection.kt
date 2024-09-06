package com.aamaulana10.moviecompose.feature.search.core.di

import com.aamaulana10.moviecompose.feature.search.core.data.ISearchRepository
import com.aamaulana10.moviecompose.feature.search.core.data.SearchRepository
import com.aamaulana10.moviecompose.feature.search.core.data.remote.SearchApiConfig
import com.aamaulana10.moviecompose.feature.search.core.data.remote.SearchRemoteDataSource
import com.aamaulana10.moviecompose.feature.search.core.domain.usecase.SearchUseCase

class SearchInjection {

    private fun provideSearchRepository(): ISearchRepository {
        val remoteDataSource = SearchRemoteDataSource(SearchApiConfig.provideApiService())
        return SearchRepository(remoteDataSource)
    }

    fun provideSearchUseCase(): SearchUseCase {
        val repository = provideSearchRepository()
        return SearchUseCase(repository)
    }
}