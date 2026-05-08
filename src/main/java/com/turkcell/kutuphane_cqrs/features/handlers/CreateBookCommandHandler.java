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

    public Book handle(CreateBookCommand command) {
        // Bilerek hata fırlatmak için test koşulu
        if ("HATA".equalsIgnoreCase(command.getBaslik())) {
            throw new RuntimeException("Transaction Rollback Testi: Bilerek hata fırlatıldı!");
        }

        Book book = new Book();
        book.setBaslik(command.getBaslik());
        book.setYazar(command.getYazar());
        book.setIsbn(command.getIsbn());
        book.setSayfaSayisi(command.getSayfaSayisi());
        
        return bookRepository.save(book);
    }
}
