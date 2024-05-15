package ada.zencas.backend.data

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "spot", uniqueConstraints = [UniqueConstraint(name = "uk_spot_name", columnNames = ["name"])])
class Spot {

    @Id
    @GeneratedValue(generator = "spot_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "spot_sequence", sequenceName = "spot_sequence", allocationSize = 1)
    val id: Long = 0

    @NotBlank
    @Column(name = "name", nullable = false, unique = true)
    var name: String = ""

    // TODO: compléter avec les autres colonnes/variables de cette table
}