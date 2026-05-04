package com.turkcell.kutuphane_cqrs.repository;

import com.turkcell.kutuphane_cqrs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
