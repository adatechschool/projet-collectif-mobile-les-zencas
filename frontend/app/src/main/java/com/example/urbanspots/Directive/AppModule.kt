package com.plcoding.jetpackcomposepokedex.di

import com.example.urbanspots.Data.Remote.ApiService
import com.example.urbanspots.Repository.SpotRepository
import com.example.urbanspots.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    val provideSpotRepository: SpotRepository
        get() = SpotRepository(getSpotsApi())

    private fun getSpotsApi(): ApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
    }
}
