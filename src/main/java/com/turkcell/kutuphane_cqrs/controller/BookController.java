package com.turkcell.kutuphane_cqrs.controller;

import com.turkcell.kutuphane_cqrs.core.mediator.Mediator;
import com.turkcell.kutuphane_cqrs.entity.Book;
import com.turkcell.kutuphane_cqrs.features.commands.CreateBookCommand;
import com.turkcell.kutuphane_cqrs.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final Mediator mediator; // Artık sadece Mediator'a güveniyoruz
    private final BookRepository bookRepository;

    @PostMapping("/add")
    public void add(@RequestBody CreateBookCommand command) throws Exception {
        // Mediator sihrini konuşturur; önce loglar, sonra süreyi ölçer, sonra handler'ı çalıştırır.
        mediator.send(command);
    }

    @GetMapping("/getall")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
