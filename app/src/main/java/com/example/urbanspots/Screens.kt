package com.example.urbanspots


sealed class  Screens (val screen : String){
    data object SpotList : Screens ("SpotList")
    data object SpotMap : Screens ("SpotMap")
    data object Filters : Screens ( "Filters")
    data object Profile : Screens ("Profile")
}