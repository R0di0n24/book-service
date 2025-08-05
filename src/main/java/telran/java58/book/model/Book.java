package telran.java58.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "isbn")
@Builder
@Entity
public class Book {
    @Id
    private String isbn;
    private String title;
    @Singular
    @ManyToMany //(fetch = FetchType.EAGER)
    private Set<Author> authors;

}
