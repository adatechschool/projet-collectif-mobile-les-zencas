package com.example.urbanspots.Data.Remote

import com.example.urbanspots.Data.Remote.Response.SpotInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("Spots/{id}")
    suspend fun GetSpotInfo(
        @Path("id") id : Int
    ) : SpotInfo
}
