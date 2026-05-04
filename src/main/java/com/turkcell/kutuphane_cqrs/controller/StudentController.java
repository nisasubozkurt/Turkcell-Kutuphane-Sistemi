package com.turkcell.kutuphane_cqrs.controller;

import com.turkcell.kutuphane_cqrs.entity.Student;
import com.turkcell.kutuphane_cqrs.features.commands.CreateStudentCommand;
import com.turkcell.kutuphane_cqrs.features.handlers.CreateStudentCommandHandler;
import com.turkcell.kutuphane_cqrs.features.handlers.GetAllStudentsQueryHandler;
import com.turkcell.kutuphane_cqrs.features.handlers.GetStudentByIdQueryHandler;
import com.turkcell.kutuphane_cqrs.features.queries.GetStudentByIdQuery;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final CreateStudentCommandHandler createStudentCommandHandler;
    private final GetAllStudentsQueryHandler getAllStudentsQueryHandler;
    private final GetStudentByIdQueryHandler getStudentByIdQueryHandler;
    

    @PostMapping("/add")
    public void add(@RequestBody CreateStudentCommand command) {
        createStudentCommandHandler.handle(command);
    }

    @GetMapping("/getall")
    public List<Student> getAll() {
        return getAllStudentsQueryHandler.handle();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return getStudentByIdQueryHandler.handle(new GetStudentByIdQuery(id));
}
}
