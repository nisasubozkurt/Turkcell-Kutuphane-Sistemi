package com.turkcell.kutuphane_cqrs.features.handlers;

import com.turkcell.kutuphane_cqrs.entity.Student;
import com.turkcell.kutuphane_cqrs.features.commands.CreateStudentCommand;
import com.turkcell.kutuphane_cqrs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStudentCommandHandler {
    private final StudentRepository studentRepository;

    public void handle(CreateStudentCommand command) {
        Student student = new Student();
        student.setAd(command.getAd());
        student.setSoyad(command.getSoyad());
        student.setStudentNo(command.getStudentNo());
        studentRepository.save(student);
    }
}
