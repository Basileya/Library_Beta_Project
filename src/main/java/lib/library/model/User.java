package lib.library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.servlet.annotation.HandlesTypes;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Integer id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "birthYear")
    private Integer birthYear;

    @Column(name = "is_delete")
    @ColumnDefault("false")
    private Boolean delete;

}
