package turkcell.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turkcell.entity.Borrowing;
import turkcell.repository.BorrowingRepository;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;

    public Borrowing lendBook(Borrowing borrowing) {
        borrowing.setVerilisTarihi(LocalDate.now()); // Bugün verildi
        borrowing.setTeslimTarihi(LocalDate.now().plusDays(14)); // 14 gün süre tanıyalım
        return borrowingRepository.save(borrowing);
    }
}
