package ada.zencas.backend.repository

import ada.zencas.backend.data.Spot
import ada.zencas.backend.data.model.SpotBasic
import ada.zencas.backend.data.model.SpotDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SpotRepository : JpaRepository<Spot, Long> {

    fun findSpotById(id: Long): Spot

}