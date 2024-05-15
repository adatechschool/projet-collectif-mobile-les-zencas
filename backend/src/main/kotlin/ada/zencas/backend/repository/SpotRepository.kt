package ada.zencas.backend.repository

import ada.zencas.backend.data.Spot
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SpotRepository : JpaRepository<Spot, Long> {


    //TODO : ajouter les fonctions nécessaires pour obtenir les données depuis la base de données
    // ATTENTION : parfois, il n'y a pas besoin d'écrire la fonction en entier, ou même de l'écrire en entier, le framework devine ce qu'on va faire juste à partir du nom de la fonction !

    fun findSpotById(id: Long): Spot

}