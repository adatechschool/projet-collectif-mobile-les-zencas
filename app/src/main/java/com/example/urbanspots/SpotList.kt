package com.example.urbanspots

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.ui.tooling.preview.Preview
import com.example.urbanspots.ui.theme.UrbanspotsTheme




class SpotsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UrbanspotsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpotListScreen("SpotList")
                }
            }
        }
    }
}

@Composable
fun SpotListScreen(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Page SpotList",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PagesPreview() {
    UrbanspotsTheme {
        SpotListScreen("Page SpotList")
    }
}






@Composable
fun SpotList () {

}

@Composable
fun SpotCard () {

}

@Composable
fun SearchBar () {

}