package com.example.urbanspots

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
- créer une validation par bouton
- uploader des vidéos
*/

@Composable
fun NewSpotScreen(){
    Column (modifier = Modifier.fillMaxSize()) {
        // TODO: centrer le titre + mettre en forme
        Text(text = "Add a new Spot !")
        Spacer(modifier = Modifier.height(20.dp))
        PhotoUpload()
        Spacer(modifier = Modifier.height(20.dp))
        DetailsInputs()
        Spacer(modifier = Modifier.height(20.dp))
        SubmitBtn()
    }
}

// TODO : Photos Upload
@Composable
fun PhotoUpload(modifier: Modifier = Modifier){
    Text(text = "photo upload")
}
// Formulaire info textuelles
// TODO: ajouter une limite de longueur des inputs (error en rouge, bouton disabled...)
@Composable
fun DetailsInputs(modifier: Modifier = Modifier){
    Column (modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 10.dp)){
        DetailInput(label = "Spot Title")
        // TODO : changer le category Input en select Input
        DetailInput(label = "Category")
        DetailInput(label = "Description")

        // TODO : ajouter un input "location" qui prend la localisation du téléphone
        // TODO : entrer la localisation (manuellement : sélectionner sur une carte)
        DetailInput(label = "Location")
    }
}

@Composable
fun DetailInput(label: String, modifier: Modifier = Modifier) {
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
/*
name
category
description
location (automatic : prendre les coordonnées GPS du téléphone)
photos
 */
@Composable
fun SubmitBtn() {
    Text(text = "submit btn")
    // TODO : centrer le bouton
}

@Preview(showBackground = true)
@Composable
fun DetailsPreview(){
    NewSpotScreen()
}
