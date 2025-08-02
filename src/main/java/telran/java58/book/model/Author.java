package telran.java58.book.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

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

}
