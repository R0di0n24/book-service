package telran.java58.book.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.java58.book.model.Publisher;

import java.beans.ConstructorProperties;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String isbn;
    private String title;
    private Set<AuthorDto> authors;
    @Setter
    private String publisher;
}

