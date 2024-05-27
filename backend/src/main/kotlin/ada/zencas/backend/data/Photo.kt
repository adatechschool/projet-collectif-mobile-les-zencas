package ada.zencas.backend.data

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "photo")
class Photo {

    @Id
    @GeneratedValue(generator = "spot_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "photo_sequence", sequenceName = "photo_sequence", allocationSize = 1)
    val id: Long = 0

    @NotBlank
    @Column(name = "url", nullable = false)
    var url: String = ""

//    @ManyToOne(cascade = arrayOf(CascadeType.ALL))
//    @JoinColumn(name = "parent_id")
//    @Column(name = "user_id", nullable = false)
//    var userId: Long = 0

//    @NotBlank
//    @Column(name = "file_name", nullable = false)
//    var fileName: String = ""
//
//    @Column(name = "size", nullable = false)
//    var size: Number = 0
//
//    @NotBlank
//    @Column(name = "type", nullable = false)
//    var type: String = ""

}