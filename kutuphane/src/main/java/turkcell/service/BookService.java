package turkcell.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turkcell.entity.Book;
import turkcell.exception.BusinessException; // Kendi yarattığımız hata sınıfı
import turkcell.repository.BookRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    // Kitap kaydederken hata kontrolü (Opsiyonel: Aynı ISBN varsa hata ver)
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException(id + " ID numaralı kitap kütüphanede bulunamadı!"));
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BusinessException("Silmek istediğiniz kitap (ID: " + id + ") zaten mevcut değil.");
        }
        bookRepository.deleteById(id);
    }
}