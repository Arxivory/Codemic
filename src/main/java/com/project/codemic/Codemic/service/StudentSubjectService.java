package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.StudentSubject;

import java.util.List;
import java.util.Optional;

public interface StudentSubjectService {
    StudentSubject createStudentSubject(StudentSubject studentSubject);

    List<StudentSubject> getAllStudentSubjects();

    Optional<StudentSubject> getStudentSubjectById(Integer id);

    StudentSubject updateStudentSubject(Integer id, StudentSubject studentSubject);

    void deleteStudentSubject(Integer id);
}
