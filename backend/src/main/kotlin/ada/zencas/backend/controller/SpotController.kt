package ada.zencas.backend.controller

import ada.zencas.backend.data.model.SpotDto
import ada.zencas.backend.service.SpotService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class SpotController(private val spotService: SpotService) {

    @GetMapping("spots")
    fun getAllSpots(): ResponseEntity<List<SpotDto>> = ResponseEntity(spotService.getAllSpots(), HttpStatus.OK)

    /* TODO: Compléter le controller en :
    - indiquant les types de requête et les url
    - créant les fonctions associées
    - utilisant les fonctions du SpotService
    */
}