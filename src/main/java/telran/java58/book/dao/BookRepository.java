package telran.java58.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java58.book.dto.AuthorDto;
import telran.java58.book.model.Author;
import telran.java58.book.model.Book;
import telran.java58.book.model.Publisher;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<Book, String> {
    Stream<Book> findBooksByPublisherPublisherName(String publisherName);

    Stream<Book> findByAuthorsAuthorName(String authorName);

    //    Stream<String> findIsbnByAuthorName(String authorName);
//    Set<Book> findBooksByAuthorName(String authorName);
//    Set<Book> findBooksByPublisherName(String publisherName);
//Stream<Book> findBooksByPublisherIs(String publisher);

}
