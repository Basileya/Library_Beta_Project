package lib.library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "authorName")
    private String authorName;

    @Column(name = "year")
    private Integer year;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "is_delete")
    @ColumnDefault("false")
    private Boolean delete;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "publishingHouse_id", nullable = false)
    private PublishingHouse publishingHouse;



    // окремо створити видавництво ентіті видавництво (one to one)
    // створити скрипт(записати в неї інформацію) sql і поставити зв'язки
    //cтворити сервіс для Book create, update,
    //delete(true false... з бази даних ніколи не видаляються дані, вони лише передають як true false), get.
    //
}
