package com.turkcell.kutuphane_cqrs.features.handlers;

import com.turkcell.kutuphane_cqrs.exception.BusinessException;
import com.turkcell.kutuphane_cqrs.features.commands.ReturnBookCommand;
import com.turkcell.kutuphane_cqrs.repository.BorrowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReturnBookCommandHandler {
    private final BorrowingRepository borrowingRepository;

    public void handle(ReturnBookCommand command) {
        // Kayıt var mı kontrol et
        if (!borrowingRepository.existsById(command.getBorrowingId())) {
            throw new BusinessException("Böyle bir ödünç alma kaydı bulunamadı!");
        }
        
        // Kaydı sil (Kitap iade edildi)
        borrowingRepository.deleteById(command.getBorrowingId());
    }
}
