package ada.zencas.backend.data.model

import java.time.LocalDateTime

data class SpotUpdateRequest(
    val name: String?,
    val category: String?,
    val description: String?,
    val latitude: String?,
    val longitude: String?,
    val photoUrl: String?,
//    val country: String,
//    val city: String,
//    val place: String,
)
