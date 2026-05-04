package com.turkcell.kutuphane_cqrs.repository;

import com.turkcell.kutuphane_cqrs.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
