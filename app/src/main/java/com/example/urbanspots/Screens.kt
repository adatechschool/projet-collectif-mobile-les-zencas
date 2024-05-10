package com.example.urbanspots

import com.example.urbanspots.Screens.Profile.screen


sealed class  Screens (val screen : String){
    data object SpotList : Screens (screen:"SpotList")
    data object SpotMap : Screens (screen:"SpotMap")
    data object Filters : Screens (screen: "Filters")
    data object Profile : Screens (screen:"Profile")
}