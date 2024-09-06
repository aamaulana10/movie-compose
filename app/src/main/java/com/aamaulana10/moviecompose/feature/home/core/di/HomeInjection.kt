package com.aamaulana10.moviecompose.feature.home.core.di

import com.aamaulana10.moviecompose.feature.home.core.data.HomeRepository
import com.aamaulana10.moviecompose.feature.home.core.data.IHomeRepository
import com.aamaulana10.moviecompose.feature.home.core.data.remote.HomeApiConfig
import com.aamaulana10.moviecompose.feature.home.core.data.remote.HomeRemoteDataSource
import com.aamaulana10.moviecompose.feature.home.core.domain.usecase.HomeUseCase

class HomeInjection {

    private fun provideHomeRepository(): IHomeRepository {
        val remoteDataSource = HomeRemoteDataSource(HomeApiConfig.provideApiService())
        return HomeRepository(remoteDataSource)
    }

    fun provideHomeUseCase(): HomeUseCase {
        val repository = provideHomeRepository()
        return HomeUseCase(repository)
    }
}