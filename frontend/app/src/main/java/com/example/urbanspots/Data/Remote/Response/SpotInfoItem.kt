package com.example.urbanspots.Data.Remote.Response

data class SpotInfoItem(
    val category: String,
    val createdOn: String,
    val id: Int,
    val latitude: String,
    val longitude: String,
    val name: String
)