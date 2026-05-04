package com.turkcell.kutuphane_cqrs.features.handlers;

import com.turkcell.kutuphane_cqrs.entity.Borrowing;
import com.turkcell.kutuphane_cqrs.features.queries.GetAllBorrowingsQuery;
import com.turkcell.kutuphane_cqrs.repository.BorrowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllBorrowingsQueryHandler {
    private final BorrowingRepository borrowingRepository;

    public List<Borrowing> handle(GetAllBorrowingsQuery query) {
        // Repository üzerinden tüm ilişkili verileri (Student ve Book dahil) getirir
        return borrowingRepository.findAll();
    }
}
