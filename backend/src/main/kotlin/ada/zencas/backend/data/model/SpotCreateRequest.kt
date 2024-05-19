package ada.zencas.backend.data.model

// import java.time.LocalDateTime

data class SpotCreateRequest(
    val name: String,
    val category: String,
    val description: String,
    val latitude: String,
    val longitude: String,
//    val country: String,
//    val city: String,
//    val place: String,
//    val createdOn: LocalDateTime
)
