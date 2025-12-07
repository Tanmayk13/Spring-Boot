package com.tanmay.day2.controller;

import com.tanmay.day2.dto.StudentDto;
import com.tanmay.day2.entity.Student;
import com.tanmay.day2.service.StudentService;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    StudentService service;

    StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/students")
    public ResponseEntity<@NonNull Student> addStudent(@RequestBody StudentDto dto) {
        Student student = service.addStudent(dto);
        return ResponseEntity.ok(student);
    }
}
