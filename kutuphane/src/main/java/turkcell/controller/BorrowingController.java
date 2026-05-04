package turkcell.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import turkcell.entity.Borrowing;
import turkcell.service.BorrowingService;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
public class BorrowingController {
    private final BorrowingService borrowingService;

    @PostMapping("/lend")
    public Borrowing lend(@RequestBody Borrowing borrowing) {
        return borrowingService.lendBook(borrowing);
    }
}