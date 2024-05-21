package com.example.urbanspots

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.urbanspots.ui.theme.AppleGreen
import com.example.urbanspots.ui.theme.UrbanspotsTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Profile() {

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "welcome" ){
            // also pass navController to each screen so we can use navController in there
            composable("welcome"){ WelcomeScreen(navController)}
            composable("login"){ LoginScreen(navController)}
            composable("signup"){ SignupScreen(navController)}
        }

}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    UrbanspotsTheme {
        Profile()
    }
}





