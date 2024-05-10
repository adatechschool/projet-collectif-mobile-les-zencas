package com.example.urbanspots

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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import java.time.format.TextStyle

@Composable
fun NewSpotScreen(){
    // TODO : remonter le state des details components dans le parent
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO: centrer le titre + mettre en forme
        Text(
            text = "Create a spot",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = 40.dp, bottom = 50.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        PhotoUpload()
        Spacer(modifier = Modifier.height(20.dp))
        DetailsInputs()
        Spacer(modifier = Modifier.height(20.dp))
        SubmitBtn()
    }
}

// TODO : créer un photos Upload
@Composable
fun PhotoUpload(modifier: Modifier = Modifier){
    Text(text = "photo upload")
    /*
    // Registers a photo picker activity launcher in single-select mode.
    val pickMedia = registerForActivityResult(PickVisualMedia()) { uri ->
        // Callback is invoked after the user selects a media item or closes the
        // photo picker.
        if (uri != null) {
            Log.d("PhotoPicker", "Selected URI: $uri")
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

    // Launch the photo picker and let the user choose images and videos.
    pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageAndVideo))

    // Launch the photo picker and let the user choose only images.
    //    pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))

     */
}


// Formulaire info textuelles
// TODO: ajouter une limite de longueur des inputs (error en rouge, bouton disabled...)
@Composable
fun DetailsInputs(modifier: Modifier = Modifier){
    Column (modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 10.dp)){
        TextInput(label = "Spot Title")
        // TODO : changer le category Input en select Input

        CategoryInput()
        TextInput(label = "Description")

        // TODO : ajouter un input "location" qui prend la localisation du téléphone
        // TODO : entrer la localisation (manuellement : sélectionner sur une carte)
        TextInput(label = "Location")
    }
}

@Composable
fun TextInput(label: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf(TextFieldValue("Entrer le détail")) }
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
/*
name
category
description
location (automatic : prendre les coordonnées GPS du téléphone)
photos
 */
@Composable
fun SubmitBtn() {
    Button(onClick = { /*TODO*/ }) {
        Text("Submit")
    }
    // TODO : centrer le bouton
    // TODO : activer le bouton (lui faire faire qch, même si on ajoutera + tard le fetch vers l'API)
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
