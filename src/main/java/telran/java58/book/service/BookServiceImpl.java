package telran.java58.book.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import telran.java58.book.dao.AuthorRepository;
import telran.java58.book.dao.BookRepository;
import telran.java58.book.dao.PublisherRepository;
import telran.java58.book.dto.AuthorDto;
import telran.java58.book.dto.BookDto;
import telran.java58.book.dto.exception.EntityExistsException;
import telran.java58.book.dto.exception.NotFoundException;
import telran.java58.book.model.Author;
import telran.java58.book.model.Book;
import telran.java58.book.model.Publisher;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void addBook(BookDto bookDto) {
        if (bookRepository.existsById(bookDto.getIsbn())) {
            throw new EntityExistsException();
        }
        // Publisher
        Publisher publisher = publisherRepository.findById(bookDto.getPublisher())
                .orElseGet(() -> publisherRepository.save(new Publisher(bookDto.getPublisher())));
        Set<Author> authors = bookDto.getAuthors().stream()
                .map(a -> authorRepository.findById(a.getAuthorName())
                        .orElseGet(() -> authorRepository.save(new Author(a.getAuthorName(), a.getBirthDate()))))
                .collect(Collectors.toSet());

        Book book = modelMapper.map(bookDto, Book.class);
        bookRepository.save(book);
    }

    @Override
    public BookDto deleteBook(String isbn) {

        return null;
    }

    @Override
    public BookDto updateBookTitle(String isbn, String title) {
        return null;
    }

    @Override
    public BookDto getBook(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(NotFoundException::new);

        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public Iterable<BookDto> findBooksByAuthor(String authorName) {
        return null;
    }

    @Override
    public Iterable<BookDto> findBooksByPublisher(String publisherName) {
        return null;
    }

    @Override
    public Iterable<AuthorDto> findAuthors(String isbn) {
        return null;
    }

    @Override
    public Iterable<String> findPublishersByAuthor(String authorName) {
        return null;
    }

    @Override
    public AuthorDto removeAuthor(String authorName) {
        return null;
    }
}
