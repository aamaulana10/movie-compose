package com.aamaulana10.moviecompose.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    var retrofit: Retrofit? = null

    fun createService(baseUrl: String): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit!!
    }

    inline fun <reified T> getService(): T {
        return retrofit!!.create(T::class.java)
    }
}