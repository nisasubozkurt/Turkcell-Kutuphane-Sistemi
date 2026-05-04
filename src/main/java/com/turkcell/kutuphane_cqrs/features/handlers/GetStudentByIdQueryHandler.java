package com.turkcell.kutuphane_cqrs.features.handlers;

import com.turkcell.kutuphane_cqrs.entity.Student;
import com.turkcell.kutuphane_cqrs.exception.BusinessException;
import com.turkcell.kutuphane_cqrs.features.queries.GetStudentByIdQuery;
import com.turkcell.kutuphane_cqrs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStudentByIdQueryHandler {
    private final StudentRepository studentRepository;

    public Student handle(GetStudentByIdQuery query) {
        return studentRepository.findById(query.getId())
                .orElseThrow(() -> new BusinessException("Öğrenci bulunamadı!"));
    }
}
