package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.dto.SubmissionDTO;
import com.project.codemic.Codemic.model.entity.Submission;
import com.project.codemic.Codemic.model.request.SubmissionRO;

import java.util.List;
import java.util.Optional;

public interface SubmissionService {
    
    void createSubmission(SubmissionRO submissionRO);
    
    List<SubmissionDTO> getAllSubmissions();
    
    Submission getSubmissionById(Integer id);
    
    void updateSubmission(Integer id, SubmissionRO submissionRO);
    
    void deleteSubmission(Integer id);
}
