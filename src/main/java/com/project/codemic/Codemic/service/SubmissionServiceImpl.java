package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Submission;
import com.project.codemic.Codemic.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    
    @Autowired
    private SubmissionRepository submissionRepository;
    
    @Override
    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }
    
    @Override
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }
    
    @Override
    public Optional<Submission> getSubmissionById(Integer id) {
        return submissionRepository.findById(id);
    }
    
    @Override
    public Submission updateSubmission(Integer id, Submission submissionDetails) {
        Optional<Submission> submissionOptional = submissionRepository.findById(id);
        if (submissionOptional.isPresent()) {
            Submission existingSubmission = submissionOptional.get();
            existingSubmission.setGrade(submissionDetails.getGrade());
            existingSubmission.setTimeComplexity(submissionDetails.getTimeComplexity());
            return submissionRepository.save(existingSubmission);
        }
        return null;
    }
    
    @Override
    public void deleteSubmission(Integer id) {
        Optional<Submission> submissionOptional = submissionRepository.findById(id);
        if (submissionOptional.isPresent())
            submissionRepository.deleteById(id);
    }
}
