package com.example.urbanspots

sealed class Screen (val itineraire : String) {
    object SpotListScreen : Screen("SpotList_Screen")
    object SpotScreen : Screen("Spot_Screen")
    object SpotMapScreen : Screen("SpotMap_Screen")
    object FilterScreen : Screen("Filter_Screen")
}
