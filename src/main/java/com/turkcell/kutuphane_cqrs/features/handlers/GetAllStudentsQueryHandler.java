package com.turkcell.kutuphane_cqrs.features.handlers;

import com.turkcell.kutuphane_cqrs.entity.Student;
import com.turkcell.kutuphane_cqrs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllStudentsQueryHandler {

    private final StudentRepository studentRepository;

    public List<Student> handle() {
        // Veritabanındaki tüm öğrencileri liste olarak döner
        return studentRepository.findAll();
    }
}
