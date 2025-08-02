package telran.java58.book.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "publisherName")
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @Column(name = "publisher_name")
    private String publisherName;
}
