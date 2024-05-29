package com.example.urbanspots.Repository

import com.example.urbanspots.Data.Remote.ApiService
import com.example.urbanspots.Data.Remote.Response.SpotInfo
import com.example.urbanspots.util.Ressource

class SpotRepository(
    private val api: ApiService
) {
    suspend fun getSpotInfo(id : Int): Ressource<SpotInfo> {
        val response = try {
            api.GetSpotInfo(id)
        } catch(e: Exception) {
            return Ressource.Error("An unknown error occurred.")
        }
        return Ressource.Success(response)
    }
}
