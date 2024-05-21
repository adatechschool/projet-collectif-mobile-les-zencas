package com.example.urbanspots

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.urbanspots.screens.DetailScreen
import com.example.urbanspots.screens.MainScreen
import com.example.urbanspots.ui.theme.UrbanspotsTheme


@Composable
fun SpotList () {
    val imageId = arrayOf(
        R.drawable.colonnes_buren,
        R.drawable.grande_mosquee,
        R.drawable.maison_rose,
        R.drawable.mur_je_t_aime,
        R.drawable.parc_sceaux,
        R.drawable.place_des_vosges,
        R.drawable.pont_des_arts,
        R.drawable.pyramide_louvre,
        R.drawable.rue_cremieux,

    )

    val names = arrayOf(
        "Les colonnes de Buren",
        "La Grande Mosquée de Paris",
        "La Maison rose",
        "Le mur des Je t'aime",
        "Le Parc de Sceaux",
        "La Place des Vosges",
        "Le Pont des Arts",
        "La Pyramide du Louvre",
        "La rue Crémieux",
        "Pont des Arts, 75006 Paris",

    )

    val destination = arrayOf(
        "Galerie de la Cour d’Honneur, 2 Rue de Montpensier, 75001 Paris",
        "2bis Pl. du Puits de l’Ermite, 75005 Paris",
        "2 Rue de l’Abreuvoir, 75018 Paris",
        "14 Pl. des Abbesses, 75018 Paris",
        "38 Av. Alphonse Cherrier, 92330 Sceaux",
        "Pl. des Vosges, 75004 Paris",
        "Le louvre 75001 Paris",
        "Rue crémieux 75012 Paris"
    )

    val description = arrayOf(

        "Commandée à l’artiste Daniel Buren, « Les deux Plateaux » plus communément appelées « Les colonnes de Buren » sont situées dans la cour d’honneur du Palais-Royal, juste à côté du jardin aux bancs-poèmes de Colette et Cocteau. Ces 260 colonnes octogonales rayées de noir et de blanc sont devenues l’un des symboles de Paris. On aime y faire des photos « cliché » ou saugrenues… Sans conteste l’un des spots extérieurs les plus Instagrammables à Paris !",
        "Si vous passez dans le 5e arrondissement de Paris, pourquoi ne pas faire une halte à la Grande Mosquée de Paris, l’une des plus anciennes mosquées de France ? La Grande Mosquée, c’est une balade au jardin des délices où il y a mille merveilles à voir et à photographier. Un véritable bijou architectural où se balader, boire un thé à la menthe autour de quelques pâtisseries orientales, promesse d’un moment hors du temps.",
        "L’iconique Maison Rose de Montmartre est l’un des lieux parisiens les plus photographiés. Avec sa belle couleur rose et ses allures de maison de campagne, elle a définitivement tout pour plaire. Mais elle n’est pas seulement belle. Ancien repaire de Piaf, d’Aznavour, de Barbara ou de Brel, elle est aujourd’hui encore et toujours une bonne table de quartier. En terrasse, on profite du charme Montmartre et de ses ruelles pavées. Attablés à l’intérieur, on admire un mobilier chiné, des vielles photos familles et on mange de bons petits plats.",
        "Il y est écrit « Je t’aime » 311 fois… Ce mur de l’amour à Montmartre se compose d’une fresque de 40m2 reprenant la plus belle déclaration du monde reproduite 311 fois, dans 250 langues différentes, à partir de 511 carreaux en lave émaillée, sur lesquels des éclats de couleur représentent les morceaux d’un cœur brisé. Une source d’inspiration sans limite.",
        "Le parc de Sceaux est sans aucun doute l’un des plus beaux parcs de la région parisienne. S’inscrivant dans la pure tradition des « jardins à la française » du XVIIe siècle, les promeneurs, photographes et Instagrameurs en herbe chériront s’y balader et y prendre de sublimes photos en toutes saisons. En avril, le Domaine national de Sceaux célèbre aussi Hanami, la fête des cerisiers en fleurs. Notre période préférée pour s’allonger dans l’herbe, pique-niquer et immortaliser les fleurs aux mille nuances de rose.",
        "La bucolique place des Vosges est l’écrin idéal des flâneurs. Au coeur de l’une des plus belles places de la capitale (si ce n’est la plus belle) on aime s’allonger dans l’herbe au soleil et se laisser bercer par les clapotis de l’eau des fontaines. À deux pas de la place des Vosges, on se plaît aussi à (re)découvrir quelques spots incontournables, à l’instar du Café Carette et de la Maison de Victor Hugo. Pour parfaire cette échappée belle parisienne, on file chez Amorino savourer une bonne glace !",
        "Sur le Pont des Arts, mon cœur vacille, entre deux eaux, l’air est si bon, cet air si pur, je le respire, nos reflets perchés, sur ce pont « … Le titre « La Seine » unissant la douce voix de Vanessa Paradis à celle de M reflète à merveille l’ambiance qui plane au dessus du Pont des Arts à Paris. Un lieu hors du temps qu’il est si doux d’immortaliser en photo.",
        "Il est l’un des lieux les plus connus de Paris : le Musée du Louvre. De jour comme de nuit, les photos sont spectaculaires. Lorsqu’il pleut, les jeux de lumières y sont encore plus divins. Oui, impossible de se lasser d’admirer la Pyramide du Louvre. S’y photographier au moins une fois dans sa vie est un incontournable !",
        "Elle est sans conteste l’une des rues les plus colorées de Paris, mais également la plus prisée de touristes et Instagrameurs – au grand dam de ses résidents… Vous l’aurez reconnue : la célèbre rue Crémieux, nichée dans le 12e arrondissement de Paris.Mais connaissez-vous son histoire et toutes ses anecdotes hautes en couleurs ? Nous vous livrons aujourd’hui quelques uns de ses petits secrets…"
    )

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable(route = "MainScreen") {
            MainScreen(imageId, names, destination, description, navController)
        }
        composable(route = "DetailScreen/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )
        ) { index->
            DetailScreen(
                photos = imageId,
                names = names,
                destination = destination,
                description = description,
                itemIndex = index.arguments?.getInt("index")
            )
        }
    }
}

