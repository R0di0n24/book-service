package telran.java58.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.Flow;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "fullName")
@Entity
@Builder
public class Author {
    @Id
    private String fullName;
    @Singular
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author(String fullName) {
        this.fullName = fullName;
    }
}
