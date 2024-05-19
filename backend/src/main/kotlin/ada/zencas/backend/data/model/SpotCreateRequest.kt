package ada.zencas.backend.data.model

import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

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

    @NotBlank(message = "created_on can't be empty")
    val createdOn: LocalDateTime
)