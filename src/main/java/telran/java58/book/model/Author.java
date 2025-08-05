package telran.java58.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "authorName")
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @Column(name = "author_name")
    private String authorName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToMany(mappedBy = "authors") //, cascade = CascadeType.ALL
    private Set<Book> books;
    public Author(String authorName, LocalDate birthDate) {
        this.authorName = authorName;
        this.birthDate = birthDate;
    }
}
