package turkcell.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turkcell.entity.Book;
import turkcell.repository.BookRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}