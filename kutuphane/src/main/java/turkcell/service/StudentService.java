package turkcell.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turkcell.entity.Student;
import turkcell.exception.BusinessException; // Kendi hatamız
import turkcell.repository.StudentRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(id + " ID'li öğrenci sistemde kayıtlı değil!"));
    }
}
