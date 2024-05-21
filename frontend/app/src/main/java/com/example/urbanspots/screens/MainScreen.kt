package com.example.urbanspots.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.urbanspots.BottomNav
import com.example.urbanspots.SpotList
import com.example.urbanspots.WelcomeScreen
import com.example.urbanspots.ui.theme.UrbanspotsTheme

@Composable
fun MainScreen(
    imageId: Array<Int>,
    names: Array<String>,
    destination: Array<String>,
    description: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = imageId.size

        items(itemCount) {
            ColumnItem(
                modifier,
                painter = imageId,
                title = names,
                destination = destination,
                description = description,
                itemIndex = it,
                navController = navController
            )
        }
    }

}

@Composable
fun ColumnItem(
    modifier: Modifier,
    painter: Array<Int>,
    title: Array<String>,
    description: Array<String>,
    destination: Array<String>,
    itemIndex: Int,
    navController: NavController
) {


    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route= "DetailScreen/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp) // Vous pouvez ajuster la hauteur selon vos besoins
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd) // Positionne la Row en haut à droite
                    .padding(12.dp), // Ajoute du padding pour l'espacement
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp) // Taille de l'icône
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .align(Alignment.BottomStart)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            ) {
            Text(
                text = title[itemIndex],
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White, // Assurez-vous que le texte soit visible sur l'image
                modifier = Modifier
                    .padding(5.dp)
            )
            Text(
                text = destination[itemIndex],
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
                modifier = Modifier
                    .padding(5.dp)
            )
            }


        }
    }
}