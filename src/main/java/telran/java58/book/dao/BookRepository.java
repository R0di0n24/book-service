package telran.java58.book.dao;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import telran.java58.book.model.Author;
import telran.java58.book.model.Book;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class BookRepository {
    @PersistenceContext//(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Transactional
    public void addBook() {
        Author markTwain = Author.builder().fullName("Mark Twain").build();
        em.persist(markTwain);
        Book book = Book.builder()
                .isbn("978-0140350173")
                .author(markTwain)
                .title("The Price and The Pauper")
                .build();
        Author ilf = Author.builder()
                .fullName("Ilya Ilf")
                .build();
        Author petrov = Author.builder()
                .fullName("Yevgeny Petrov")
                .build();
        em.persist(ilf);
        em.persist(petrov);
        Book chairs12 = Book.builder()
                .isbn("978-0810114845")
                .author(ilf)
                .author(petrov)
                .title("The Twelve Chairs")
                .build();
        em.persist(chairs12);
    }
@Transactional(readOnly = true)
    public void printAuthorsOfBook(String isbn) {
//        Book book = em.find(Book.class, isbn);
    TypedQuery<Book> query = em.createQuery("select b from Book b left join fetch b.authors a where b.isbn = :isbn", Book.class);
    query.setParameter("isbn", isbn);
    Book book  = query.getSingleResult();
    Set<Author> authors = book.getAuthors();
    authors.forEach(a -> System.out.println(a.getFullName()));
    }

}
