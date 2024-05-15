package ada.zencas.backend.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
data class SpotNotFoundException(override val message: String) : RuntimeException()
