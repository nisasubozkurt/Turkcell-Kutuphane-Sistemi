package com.turkcell.kutuphane_cqrs.repository;

import com.turkcell.kutuphane_cqrs.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
