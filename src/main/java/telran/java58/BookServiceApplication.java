package telran.java58;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import telran.java58.book.dao.BookRepository;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;
    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.addBook();
        bookRepository.printAuthorsOfBook("978-0810114845");
    }
}
