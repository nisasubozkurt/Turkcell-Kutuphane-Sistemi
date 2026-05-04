package com.turkcell.kutuphane_cqrs.features.handlers;

import com.turkcell.kutuphane_cqrs.entity.Book;
import com.turkcell.kutuphane_cqrs.entity.Borrowing;
import com.turkcell.kutuphane_cqrs.entity.Student;
import com.turkcell.kutuphane_cqrs.exception.BusinessException;
import com.turkcell.kutuphane_cqrs.features.commands.CreateBorrowingCommand;
import com.turkcell.kutuphane_cqrs.repository.BookRepository;
import com.turkcell.kutuphane_cqrs.repository.BorrowingRepository;
import com.turkcell.kutuphane_cqrs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBorrowingCommandHandler {
    private final BorrowingRepository borrowingRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public void handle(CreateBorrowingCommand command) {
        // 1. Öğrenciyi bul
        Student student = studentRepository.findById(command.getStudentId())
                .orElseThrow(() -> new BusinessException("Öğrenci bulunamadı!"));
        
        // 2. Kitabı bul
        Book book = bookRepository.findById(command.getBookId())
                .orElseThrow(() -> new BusinessException("Kitap bulunamadı!"));

        // 3. İlişkili nesneleri setle
        Borrowing borrowing = new Borrowing();
        borrowing.setStudent(student);
        borrowing.setBook(book);

        // 4. Kaydet
        borrowingRepository.save(borrowing);
    }
}
