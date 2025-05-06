package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
}
