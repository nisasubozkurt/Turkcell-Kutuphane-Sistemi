package turkcell.controller;

import jakarta.validation.Valid; // ÖNEMLİ: Doğrulama için gerekli import
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import turkcell.entity.Student;
import turkcell.service.StudentService;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    // ÖDEV İÇİN: @Valid ekledik. Artık isim boşsa veya kurallara uymuyorsa hata fırlatacak.
    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}