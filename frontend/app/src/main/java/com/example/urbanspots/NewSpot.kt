package com.example.urbanspots

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun NewSpotScreen(){
    // TODO : remonter le state des details components dans le parent
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize()
        ) {

            Box(modifier =  Modifier.fillMaxSize()){


                /// Content

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp)
                ) {

                    // Logo
                    Image(painter = painterResource(id = R.drawable.logo_black),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 54.dp)
                            .height(100.dp)
                            .align(Alignment.Start)
                            .offset(x = (-20).dp)
                    )

                    Text(text = "Add a spot",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black
                        ),
                        modifier = Modifier.align(Alignment.Start)
                    )

                    Text("Share your spot to create unforgettable experiences",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(bottom = 24.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    DetailsInputs()
                    Spacer(modifier = Modifier.height(20.dp))
                    PhotoUpload()
                    Spacer(modifier = Modifier.height(20.dp))
                }
                SubmitBtn()
            }
        }
    }
}

// TODO : créer un photos Upload
@Composable
fun PhotoUpload(modifier: Modifier = Modifier){
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri })

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = {
                        singlePhotoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                ) {
                    Text(text = "Pick one photo")
                }
            }
        }

        item {
            AsyncImage(
                model = selectedImageUri,
                contentDescription =  null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}


// Formulaire info textuelles
// TODO: ajouter une limite de longueur des inputs (error en rouge, bouton disabled...)
@Composable
fun DetailsInputs(modifier: Modifier = Modifier){
    Column (modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 10.dp)){
        TextInput(label = "Spot Title")
        // TODO : changer le category Input en select Input

        TextInput(label = "Category")
        TextInput(label = "Description")

        // TODO : ajouter un input "location" qui prend la localisation du téléphone
        // TODO : entrer la localisation (manuellement : sélectionner sur une carte)
        TextInput(label = "Location")
    }
}

@Composable
fun TextInput(label: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf(TextFieldValue("Enter the details")) }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        supportingText = { Text(text = "*required")},
        isError = false,
        keyboardOptions = KeyboardOptions(KeyboardCapitalization.Sentences),
        modifier = Modifier.padding(10.dp, 6.dp)
        // TODO : focus sur l'input suivant quand le User appuie sur "next"
    )
}

@Composable
fun CategoryInput(){
    Text(text = "menu déroulant à ajouter")
}

@Composable
fun SubmitBtn(modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Button(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth()
                .height(60.dp)
        ) {
            Text("Submit")
        }
    }
    /* TODO : ajouter les actions effectuées par le bouton "submit" :
        - récupérer la localisation du téléphone
        - organiser les données récupérées
        - déclencher le call API (ou la sauvegarde dans le fichier JSON/le repo)
     */
}

@Preview(showBackground = true)
@Composable
fun DetailsPreview(){
    NewSpotScreen()
}

@Composable
fun DropdownMenuExample() {
    // State to manage the visibility of the dropdown menu
    val dropdownExpanded = remember { mutableStateOf(false) }
    // State to manage the selected item
    val selectedItem = remember { mutableStateOf("") }

    Column {
        // Dropdown Button
        TextButton(onClick = { dropdownExpanded.value = true }) {
            Text(text = "Select an item")
        }

        // Dropdown Menu
        DropdownMenu(
            expanded = dropdownExpanded.value,
            onDismissRequest = { dropdownExpanded.value = false }
        ) {
            // Dropdown Menu Items
            Column {
                DropdownMenuItem(text = { Text("aaaa") },
                    onClick = {
                        selectedItem.value = "a"
                        dropdownExpanded.value = false
                    })
                DropdownMenuItem(text = { Text("baaaa") },
                    onClick = {
                        selectedItem.value = "b"
                        dropdownExpanded.value = false
                    })
                DropdownMenuItem(text = { Text("ccccc") },
                    onClick = {
                        selectedItem.value = "c"
                        dropdownExpanded.value = false
                    })
            }
        }

        // Display the selected item
        Text(text = "Selected item: ${selectedItem.value}", modifier = Modifier.padding(top = 16.dp))
    }
}