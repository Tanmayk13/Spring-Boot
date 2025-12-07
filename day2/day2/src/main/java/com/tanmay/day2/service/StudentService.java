package com.tanmay.day2.service;

import com.tanmay.day2.dto.StudentDto;
import com.tanmay.day2.entity.Student;
import com.tanmay.day2.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository repo;

    StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(StudentDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        return repo.save(student);
    }
}
