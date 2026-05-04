package turkcell.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turkcell.entity.Borrowing;
import turkcell.exception.BusinessException;
import turkcell.repository.BorrowingRepository;
import turkcell.repository.BookRepository;
import turkcell.repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    public Borrowing lendBook(Borrowing request) {
        // 1. Kontrol: Kitap var mı?
        bookRepository.findById(request.getBook().getId())
                .orElseThrow(() -> new BusinessException("Ödünç verilmek istenen kitap bulunamadı!"));

        // 2. Kontrol: Öğrenci var mı?
        studentRepository.findById(request.getStudent().getId())
                .orElseThrow(() -> new BusinessException("Kitap verilmek istenen öğrenci bulunamadı!"));

        Borrowing borrowing = new Borrowing();
        borrowing.setStudent(request.getStudent());
        borrowing.setBook(request.getBook());
        borrowing.setVerilisTarihi(LocalDate.now());
        borrowing.setTeslimTarihi(LocalDate.now().plusDays(14));

        return borrowingRepository.save(borrowing);
    }

    public List<Borrowing> getAll() {
        return borrowingRepository.findAll();
    }

    public void returnBook(Long id) {
        if (!borrowingRepository.existsById(id)) {
            throw new BusinessException("Bu ID ile bir ödünç kaydı yok, iade edilemez!");
        }
        borrowingRepository.deleteById(id);
    }
}
