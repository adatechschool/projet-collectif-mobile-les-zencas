package com.example.urbanspots

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SpotScreen() {

    val images = listOf(
        R.drawable.space1,
        R.drawable.space2,
        R.drawable.space3
    )
    val pagerState = rememberPagerState(pageCount = { images.size })

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Ajout de boutons de navigation
    }
}

@Composable
fun SpotCarrousel () {

}

@Composable
fun SpotDetails () {

}

@Composable
fun BackwardBtn () {

}

@Preview (showBackground = true)
@Composable
fun Preview() {
    SpotScreen()
}


