package ada.zencas.backend.service

import ada.zencas.backend.data.Spot
import ada.zencas.backend.data.model.SpotBasic
import ada.zencas.backend.data.model.SpotCreateRequest
import ada.zencas.backend.data.model.SpotDetail
import ada.zencas.backend.repository.SpotRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SpotService(private val repository: SpotRepository) {

    private fun convertEntityToSpotDetail(spot: Spot): SpotDetail {
        return SpotDetail(
            spot.id,
            spot.name,
            spot.category,
            spot.description,
            spot.latitude,
            spot.longitude,
//            spot.country,
//            spot.city,
//            spot.place,
            spot.createdOn
        )
    }

    private fun convertEntityToSpotBasic(spot: Spot): SpotBasic{
        return SpotBasic(
            spot.id,
            spot.name,
            spot.category,
            spot.latitude,
            spot.longitude,
//            spot.country,
//            spot.city,
//            spot.place,
            spot.createdOn
        )
    }

    private fun assignValuesToEntity(spot: Spot, spotRequest: SpotCreateRequest) {
        spot.name = spotRequest.name
        spot.category = spotRequest.category
        spot.description = spotRequest.description
        spot.latitude = spotRequest.latitude
        spot.longitude = spotRequest.longitude
        spot.createdOn = spotRequest.createdOn
    }


    fun getAllSpots(): List<SpotBasic> =
        repository.findAll().stream().map(this::convertEntityToSpotBasic).collect(Collectors.toList())

//    fun getSpotById(id: Long): SpotDto {
//    }


}
