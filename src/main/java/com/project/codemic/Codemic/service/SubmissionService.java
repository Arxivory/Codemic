package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Submission;

import java.util.List;
import java.util.Optional;

public interface SubmissionService {
    
    Submission createSubmission(Submission submission);
    
    List<Submission> getAllSubmissions();
    
    Optional<Submission> getSubmissionById(Integer id);
    
    Submission updateSubmission(Integer id, Submission submissionDetails);
    
    void deleteSubmission(Integer id);
}
