package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.dto.StudentDTO;
import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.request.StudentRO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    String STUDENTS = "Students";

    String STUDENT = "Student";

    void createStudent(StudentRO studentRO);

    List<StudentDTO> getAllStudents();

    Student getStudentById(Integer id);

    void updateStudent(Integer id, StudentRO studentRO);

    void deleteStudent(Integer id);
}
