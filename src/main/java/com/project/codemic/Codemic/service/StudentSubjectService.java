package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.dto.StudentSubjectDTO;
import com.project.codemic.Codemic.model.entity.StudentSubject;
import com.project.codemic.Codemic.model.request.StudentSubjectRO;

import java.util.List;
import java.util.Optional;

public interface StudentSubjectService {
    void createStudentSubject(StudentSubjectRO studentSubjectRO);

    List<StudentSubjectDTO> getAllStudentSubjects();

    StudentSubject getStudentSubjectById(Integer id);

    void updateStudentSubject(Integer id, StudentSubjectRO studentSubjectRO);

    void deleteStudentSubject(Integer id);
}
