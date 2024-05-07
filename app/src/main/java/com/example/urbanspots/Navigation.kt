package com.example.urbanspots

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SpotScreen.itineraire) {
        composable(route = Screen.SpotScreen.itineraire) {
            SpotScreen()
        }
    }

}