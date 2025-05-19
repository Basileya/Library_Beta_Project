package lib.library.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "publishingHouse")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PublishingHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Integer id;

    @Column(name = "publishing_house")
    private String name;

    @Column(name = "is_delete")
    @ColumnDefault("false")
    private Boolean delete;

}
