package com.example.urbanspots


sealed class  Screens (val screen : String){
    data object MainScreen : Screens ("main_screen")
    data object SpotMap : Screens ("SpotMap")
    data object Filters : Screens ( "Filters")
    data object Profile : Screens ("Profile")
}