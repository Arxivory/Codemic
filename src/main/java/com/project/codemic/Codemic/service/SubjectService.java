package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    
    Subject createSubject(Subject subject);
    
    List<Subject> getAllSubjects();
    
    Optional<Subject> getSubjectById(Integer id);
    
    Subject updateSubject(Integer id, Subject subjectDetails);
    
    void deleteSubject(Integer id);
}
