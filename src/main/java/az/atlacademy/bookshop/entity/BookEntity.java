package az.atlacademy.bookshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @NotEmpty(message = "Kitab adı boş ola bilməz")
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    //    @Min(value = 1, message = "Say 1-dən az ola bilməz")
    private Integer count;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
}
