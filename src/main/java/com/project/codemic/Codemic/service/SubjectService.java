package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.dto.SubjectDTO;
import com.project.codemic.Codemic.model.entity.Subject;
import com.project.codemic.Codemic.model.request.SubjectRO;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    
    void createSubject(SubjectRO subjectRO);
    
    List<SubjectDTO> getAllSubjects();
    
    Subject getSubjectById(Integer id);
    
    void updateSubject(Integer id, SubjectRO subjectRO);
    
    void deleteSubject(Integer id);
}
