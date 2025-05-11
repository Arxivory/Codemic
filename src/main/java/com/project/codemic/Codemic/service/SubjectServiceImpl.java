package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Subject;
import com.project.codemic.Codemic.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
    
    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
    
    @Override
    public Optional<Subject> getSubjectById(Integer id) {
        return subjectRepository.findById(id);
    }
    
    @Override
    public Subject updateSubject(Integer id, Subject subjectDetails) {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if (subjectOptional.isPresent()) {
            Subject updatedSubject = subjectOptional.get();
            updatedSubject.setName(subjectDetails.getName());
            updatedSubject.setDescription(subjectDetails.getDescription());
            updatedSubject.setCredits(subjectDetails.getCredits());
            return subjectRepository.save(updatedSubject);
        }
        return null;
    }
    
    @Override
    public void deleteSubject(Integer id) {
        subjectRepository.deleteById(id);
    }
}
