package ada.zencas.backend.data.model

import java.time.LocalDateTime

// TODO: compléter le Dto en indiquant les caractéristiques de l'objt qui sera manipulé par ce back-end
data class SpotDetail(
    val id: Long,
    val name: String,
    val category: String,
    val description: String,
    val latitude: String,
    val longitude: String,
    val photoUrl: String,
//    val country: String,
//    val city: String,
//    val place: String,
    val createdOn: LocalDateTime
)
