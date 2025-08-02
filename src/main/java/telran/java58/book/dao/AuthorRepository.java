package telran.java58.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java58.book.model.Author;
import telran.java58.book.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
