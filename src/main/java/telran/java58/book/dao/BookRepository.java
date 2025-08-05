package telran.java58.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java58.book.model.Book;
import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<Book, String> {

//    Stream<Book> findBooksByPublisherPublisherName(String publisherName);
//
//    Stream<Book> findBooksByAuthorsAuthorName(String authorName);

}
