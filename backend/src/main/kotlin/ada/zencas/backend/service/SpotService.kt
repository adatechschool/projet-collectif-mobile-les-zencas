package ada.zencas.backend.service

import ada.zencas.backend.data.Spot
import ada.zencas.backend.data.model.SpotDto
import ada.zencas.backend.exception.SpotNotFoundException
import ada.zencas.backend.repository.SpotRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SpotService(private val repository: SpotRepository) {

    fun getAllSpots(): List<SpotDto> =
        repository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList())

    // TODO: compléter avec les fonctions nécessaires
//    fun getSpotById(id: Long): SpotDto {
//    }

    private fun convertEntityToDto(spot: Spot): SpotDto {
        return SpotDto(
            spot.id,
            spot.name
        )
    }

    // TODO : compléter le mapping entre le dto et l'entity
    private fun assignValuesToEntity(spot: Spot, spotRequest: Spot) {
        spot.name = spotRequest.name
    }

}
