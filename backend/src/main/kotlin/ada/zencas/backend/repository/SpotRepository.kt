package ada.zencas.backend.repository

import ada.zencas.backend.data.Spot
import ada.zencas.backend.data.model.SpotBasic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SpotRepository : JpaRepository<Spot, Long> {

}