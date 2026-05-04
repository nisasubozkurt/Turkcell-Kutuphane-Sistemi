package com.turkcell.kutuphane_cqrs.features.handlers;

import com.turkcell.kutuphane_cqrs.entity.Book;
import com.turkcell.kutuphane_cqrs.features.commands.CreateBookCommand;
import com.turkcell.kutuphane_cqrs.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookCommandHandler {
    private final BookRepository bookRepository;

    public void handle(CreateBookCommand command) {
        Book book = new Book();
        book.setBaslik(command.getBaslik());
        book.setYazar(command.getYazar());
        book.setIsbn(command.getIsbn());
        book.setSayfaSayisi(command.getSayfaSayisi());
        bookRepository.save(book);
    }
}
