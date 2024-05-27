package ada.zencas.backend.data.model

import java.time.LocalDateTime

data class SpotBasic(
    val id: Long,
    val name: String,
    val category: String,
    val latitude: String,
    val longitude: String,
    val photoUrl: String,
//    val country: String,
//    val city: String,
//    val place: String,
    val createdOn: LocalDateTime
)
