package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.exception.ResourceNotFoundException;
import com.project.codemic.Codemic.model.dto.SubmissionDTO;
import com.project.codemic.Codemic.model.entity.Activity;
import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.entity.Submission;
import com.project.codemic.Codemic.model.mapper.SubmissionMapper;
import com.project.codemic.Codemic.model.request.SubmissionRO;
import com.project.codemic.Codemic.repository.SubmissionRepository;
import com.project.codemic.Codemic.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SubmissionServiceImpl implements SubmissionService {

    public static final String SUBMISSIONS = "Submissions";

    public static final String SUBMISSION = "Submission";
    
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SubmissionMapper submissionMapper;


    @Override
    public void createSubmission(SubmissionRO submissionRO) {
        try {
            Activity activity = activityService.getActivityById(submissionRO.activityId());

            submissionRepository.save(submissionRO.toEntity(null, activity));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(SUBMISSION);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public List<SubmissionDTO> getAllSubmissions() {
        try {
            List<Submission> submissions = submissionRepository.findAll();
            log.info(MessageUtils.retrieveSuccessMessage(SUBMISSIONS));
            return submissions.stream().map(submissionMapper::toDTO).toList();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(SUBMISSIONS);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public Submission getSubmissionById(Integer id) {
        try {
            Optional<Submission> submissionOptional = submissionRepository.findById(id);
            if (submissionOptional.isEmpty())
                throw new Exception("Submission not found.");

            log.info(MessageUtils.retrieveSuccessMessage(SUBMISSION));
            return submissionOptional.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(SUBMISSION);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void updateSubmission(Integer id, SubmissionRO submissionRO) {
        try {
            Optional<Submission> submissionOptional = submissionRepository.findById(id);
            if (submissionOptional.isEmpty())
                throw new ResourceNotFoundException("Submission not found to be updated :(.");
            submissionRepository.save(submissionRO.toEntity(submissionOptional.get(), submissionOptional.get().getActivity()));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(SUBMISSION);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void deleteSubmission(Integer id) {
        try {
            Optional<Submission> submissionOptional = submissionRepository.findById(id);

            if (submissionOptional.isEmpty())
                throw new ResourceNotFoundException("Submission not found to be deleted :(.");

            submissionRepository.deleteById(id);
        } catch (Exception e) {
            String errorMessage = MessageUtils.deleteErrorMessage(SUBMISSION);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
}
