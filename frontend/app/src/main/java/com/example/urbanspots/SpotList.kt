package com.example.urbanspots

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.urbanspots.screens.DetailScreen
import com.example.urbanspots.screens.MainScreen


@Composable
fun SpotList () {
    val imageId = arrayOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4,
        R.drawable.photo5,
        R.drawable.photo6
    )

    val names = arrayOf(
        "Château abandonné",
        "Immeuble Lavirotte",
        "Façade parisienne",
        "Fontaines de la Concorde",
        "Fontaine de Médicis",
        "Porte de l’immeuble Lavirotte"
    )

    val description = arrayOf(
        "150m",
        "250m",
        "200m",
        "50m",
        "100m",
        "150m"

        // "Un château abandonné pour une virée urbex.",
        // "L’immeuble Lavirotte, a été construit en 1900 par l’architecte Jules Lavirotte, pour le céramiste Alexandre Bigot. L’année suivante, en 1901, l’édifice du 7e arrondissement de Paris gagne le concours de façades de la Ville de Paris. Un véritable Chef-d’oeuvre de l’Art Nouveau orné de céramiques, moulures et balcons sculptés dont la façade et la toiture ont été inscrites en 1964 au titre des Monuments Historiques.",
        // "Une façade parisienne vraiment stylée à Paris.",
        // "Directement inspirées des Fontaines de la place Saint-Pierre à Rome, les Fontaines de la place de la Concorde sont un fleuron du patrimoine parisien, et assurément les plus belles fontaines de Paris. Construites de part et d’autre de l’Obélisque entre 1837 et 1840 par l’architecte Jacques Hittorff, elles sont destinées sublimer la place de la Concorde. La Fontaine des Fleuves, au nord, et la Fontaine des Mers, au sud, surprennent par la diversité de leurs ornements. L’info à retenir ? Les tritons et les néréides sculptés évoquent la devise de Paris « Fluctuat nec mergitur » ",
        // "La plus romantique des fontaines parisiennes a été édifiée vers 1630 sur commande de Marie de Médicis. Nichée dans le jardin du Luxembourg, côté Sénat, elle offre à la vue de tous une scène de la mythologie grecque sculptée par Auguste Ottin. Rien d’étonnant donc, à tomber sur le cyclope Polyphème, la déesse Galatée, le dieu Pan et Diane la Chasseresse au détour d’un bosquet. Une nymphée directement inspirée du jardin de Boboli à Florence.",
        // "Conçu par Jules Lavirotte entre 1900 et 1901, cet immeuble est une véritable ode à l’Art nouveau. Formes organiques, éléments végétaux, architecture irrégulière… Toute la liberté du mouvement s’exprime sur la façade (primée en 1901). La porte est évidemment au diapason. Cernée d’une arcade sculptée par Jean-Baptiste Larrivé, cette merveille en bois et verre mériterait un article à elle seule, rien que pour lister toutes les allusions coquines qu’elle renferme. Oui, vous avez bien lu. En regardant bien, une forme phallique se dessine grâce au verre et aux tiges de ferronnerie au centre de la porte XXL. Il paraît que l’archi, un poil obsédé, a aussi ponctué le hall d’entrée et la cour de symboles olé olé. Pour les voir, il ne reste plus qu’à espérer croiser un résident sympa qui acceptera de vous ouvrir."
    )

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable(route = "MainScreen") {
            MainScreen(imageId, names, description, navController)
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
                description = description,
                itemIndex = index.arguments?.getInt("index")
            )
        }
    }
}
