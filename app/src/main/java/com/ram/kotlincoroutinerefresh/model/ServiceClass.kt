package com.ram.kotlincoroutinerefresh.model

import com.ram.kotlincoroutinerefresh.api.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceClass {
    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(ApiInterface.BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiInterface::class.java)
}