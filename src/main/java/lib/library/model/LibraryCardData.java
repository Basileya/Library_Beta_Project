package lib.library.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "libraryCardData")
public class LibraryCardData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "is_delete")
    @ColumnDefault("false")
    private Boolean delete;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    // у карті має бути посилання на користувача
    // яку книжку взяв
    // на скільки взяв (з - по)
    // кількість книг які взяв
    // String note. (примітки щодо книг, в якому стані).

}
