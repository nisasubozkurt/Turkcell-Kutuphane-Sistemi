package turkcell.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turkcell.entity.Student;
import turkcell.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
