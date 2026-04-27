package turkcell.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import turkcell.entity.Book;
import turkcell.service.BookService;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }
}