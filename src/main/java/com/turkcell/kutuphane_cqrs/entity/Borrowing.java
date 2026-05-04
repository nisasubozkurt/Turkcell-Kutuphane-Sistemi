package com.turkcell.kutuphane_cqrs.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "borrowings")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Borrowing {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}