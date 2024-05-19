package ada.zencas.backend.service

import ada.zencas.backend.data.Spot
import ada.zencas.backend.data.model.SpotBasic
import ada.zencas.backend.data.model.SpotCreateRequest
import ada.zencas.backend.data.model.SpotDetail
import ada.zencas.backend.data.model.SpotUpdateRequest
import ada.zencas.backend.exception.SpotNotFoundException
import ada.zencas.backend.repository.SpotRepository
import org.springframework.stereotype.Service
import org.springframework.util.ReflectionUtils
import java.lang.reflect.Field
import java.util.stream.Collectors
import kotlin.reflect.full.memberProperties

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
    }

    private fun checkForSpotId(id: Long): Boolean {
        if (!repository.existsById(id)) {
            throw SpotNotFoundException("Spot with ID: $id does not exist!")
        }
        return true
    }

    fun getAllSpots(): List<SpotBasic> =
        repository.findAll().stream().map(this::convertEntityToSpotBasic).collect(Collectors.toList())

    fun getSpotById(id: Long): SpotDetail {
        checkForSpotId(id)
        val spot: Spot = repository.findSpotById(id)
        return convertEntityToSpotDetail(spot)
    }

    fun createSpot(createRequest: SpotCreateRequest): SpotDetail {
        val spot = Spot()
        assignValuesToEntity(spot, createRequest)
        val savedSpot = repository.save(spot)
        return convertEntityToSpotDetail(savedSpot)
    }

    fun updateSpot(id: Long, updateRequest: SpotUpdateRequest): SpotDetail {
        checkForSpotId(id)
        val existingSpot: Spot = repository.findSpotById(id)

        for (prop in SpotUpdateRequest::class.memberProperties) {
            if (prop.get(updateRequest) != null) {
                val field: Field? = ReflectionUtils.findField(Spot::class.java, prop.name)
                field?.let {
                    it.isAccessible = true
                    ReflectionUtils.setField(it, existingSpot, prop.get(updateRequest))
                }
            }
        }

        val savedTask: Spot = repository.save(existingSpot)
        return convertEntityToSpotDetail(savedTask)
    }

    fun deleteSpot(id: Long): String {
        checkForSpotId(id)
        repository.deleteById(id)
        return "Spot with id: $id has been deleted."
    }

}
