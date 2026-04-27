package turkcell.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import turkcell.entity.Student;
import turkcell.service.StudentService;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}
