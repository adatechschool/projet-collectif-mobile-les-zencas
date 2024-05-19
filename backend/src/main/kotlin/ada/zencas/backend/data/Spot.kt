package ada.zencas.backend.data

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "spot")
class Spot {

    @Id
    @GeneratedValue(generator = "spot_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "spot_sequence", sequenceName = "spot_sequence", allocationSize = 1)
    val id: Long = 0

    @NotBlank
    @Column(name = "name", nullable = false, unique = true)
    var name: String = ""

    @NotBlank
    @Column(name = "category", nullable = false)
    var category: String = ""

    @Column(name = "description", nullable = false)
    var description: String = ""

    @NotBlank
    @Column(name = "latitude", nullable = false)
    var latitude: String = ""

    @NotBlank
    @Column(name = "longitude", nullable = false)
    var longitude: String = ""

    @NotBlank
    @Column(name = "country", nullable = false)
    var country: String = ""

    @NotBlank
    @Column(name = "city", nullable = false)
    var city: String = ""

    @NotBlank
    @Column(name = "place", nullable = false)
    var place: String = ""

//    @NotBlank
//    @Column(name = "user_id", nullable = false)
//    var userId: String = ""

}