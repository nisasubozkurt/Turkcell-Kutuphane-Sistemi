package com.turkcell.kutuphane_cqrs.controller;

import com.turkcell.kutuphane_cqrs.entity.Book;
import com.turkcell.kutuphane_cqrs.features.commands.CreateBookCommand;
import com.turkcell.kutuphane_cqrs.features.handlers.CreateBookCommandHandler;
import com.turkcell.kutuphane_cqrs.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final CreateBookCommandHandler createBookCommandHandler;
    private final BookRepository bookRepository;

    @PostMapping("/add")
    public void add(@RequestBody CreateBookCommand command) {
        createBookCommandHandler.handle(command);
    }

    @GetMapping("/getall")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
