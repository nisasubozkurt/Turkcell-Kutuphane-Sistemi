package com.turkcell.kutuphane_cqrs.controller;

import com.turkcell.kutuphane_cqrs.entity.Borrowing;
import com.turkcell.kutuphane_cqrs.features.commands.CreateBorrowingCommand;
import com.turkcell.kutuphane_cqrs.features.handlers.CreateBorrowingCommandHandler;
import com.turkcell.kutuphane_cqrs.features.handlers.GetAllBorrowingsQueryHandler;
import com.turkcell.kutuphane_cqrs.features.queries.GetAllBorrowingsQuery;
import com.turkcell.kutuphane_cqrs.features.commands.ReturnBookCommand;
import com.turkcell.kutuphane_cqrs.features.handlers.ReturnBookCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowings")
@RequiredArgsConstructor
public class BorrowingController {

    private final CreateBorrowingCommandHandler createBorrowingCommandHandler;
    private final GetAllBorrowingsQueryHandler getAllBorrowingsQueryHandler;
    private final ReturnBookCommandHandler returnBookCommandHandler;

    @PostMapping("/add")
    public void add(@RequestBody CreateBorrowingCommand command) {
        createBorrowingCommandHandler.handle(command);
    }

    @GetMapping("/getall")
    public List<Borrowing> getAll() {
        // Artık repository yerine Handler üzerinden geçiyoruz
        return getAllBorrowingsQueryHandler.handle(new GetAllBorrowingsQuery());
    }

    @DeleteMapping("/return/{id}")
    public void returnBook(@PathVariable Long id) {
        returnBookCommandHandler.handle(new ReturnBookCommand(id));
}
}
