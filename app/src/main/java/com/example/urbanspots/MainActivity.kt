package com.example.urbanspots
import Profile
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.urbanspots.ui.theme.AppleGreen
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.urbanspots.ui.theme.UrbanspotsTheme


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }
            setOnExitAnimationListener { screen ->
                val zoomX = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.4f,
                    0.0f
                )
                zoomX.interpolator = OvershootInterpolator()
                zoomX.duration = 500L
                zoomX.doOnEnd { screen.remove() }

                val zoomY = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.4f,
                    0.0f
                )
                zoomY.interpolator = OvershootInterpolator()
                zoomY.duration = 500L
                zoomY.doOnEnd { screen.remove() }

                zoomX.start()
                zoomY.start()
            }
        }

        setContent {
            UrbanspotsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    BottomNav()
                }
            }
        }
    }
}


@Composable
fun BottomNav () {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)

    }

    Scaffold(
        bottomBar = {
            BottomAppBar (
                containerColor = AppleGreen
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(Screens.SpotList.screen){
                            popUpTo(0)
                        }
                    },

                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Home, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray)

                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Place
                        navigationController.navigate(Screens.SpotMap.screen){
                            popUpTo(0)
                        }
                    },

                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Place, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Place) Color.White else Color.DarkGray)

                }
                Box(modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                    contentAlignment = Alignment.Center) {
                    FloatingActionButton(onClick = { Toast.makeText(context,"Add a New Spot", Toast.LENGTH_SHORT).show() }) {
                        Icon(Icons.Default.Add , contentDescription = null, tint = AppleGreen )
                    }

                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navigationController.navigate(Screens.Filters.screen){
                            popUpTo(0)
                        }
                    },

                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray)

                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screens.Profile.screen){
                            popUpTo(0)
                        }
                    },

                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray)

                }


            }

        }
    )
    {
            paddingValues ->
        NavHost(navController = navigationController, startDestination = Screens.SpotList.screen,
            modifier = Modifier.padding(paddingValues)) {
            composable(Screens.SpotList.screen){ SpotList()}
            composable(Screens.SpotMap.screen){ SpotMap() }
            composable(Screens.Filters.screen){ Filters()}
            composable(Screens.Profile.screen){ Profile()}


        }

    }

}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    UrbanspotsTheme {
        BottomNav()
    }
}