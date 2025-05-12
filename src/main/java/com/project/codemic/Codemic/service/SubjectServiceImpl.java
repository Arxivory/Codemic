package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.exception.ResourceNotFoundException;
import com.project.codemic.Codemic.model.dto.SubjectDTO;
import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.entity.Subject;
import com.project.codemic.Codemic.model.mapper.SubjectMapper;
import com.project.codemic.Codemic.model.request.SubjectRO;
import com.project.codemic.Codemic.repository.SubjectRepository;
import com.project.codemic.Codemic.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SubjectServiceImpl implements SubjectService {

    public static final String SUBJECTS = "Subjects";

    public static final String SUBJECT = "Subject";
    
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectMapper subjectMapper;
    
    @Override
    public void createSubject(SubjectRO subjectRO) {
        try {
            subjectRepository.save(subjectRO.toEntity(null, null));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(SUBJECT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
    
    @Override
    public List<SubjectDTO> getAllSubjects() {
        try {
            List<Subject> subjects = subjectRepository.findAll();
            log.info(MessageUtils.retrieveSuccessMessage(SUBJECTS));
            return subjects.stream().map(subjectMapper::toDTO).toList();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(SUBJECTS);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
    
    @Override
    public Subject getSubjectById(Integer id) {
        try {
            Optional<Subject> subjectOptional = subjectRepository.findById(id);
            if (subjectOptional.isEmpty())
                throw new Exception("Subject not found.");

            log.info(MessageUtils.retrieveSuccessMessage(SUBJECT));
            return subjectOptional.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(SUBJECT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
    
    @Override
    public void updateSubject(Integer id, SubjectRO subjectRO) {
        try {
            Optional<Subject> subjectOptional = subjectRepository.findById(id);
            if (subjectOptional.isEmpty())
                throw new ResourceNotFoundException("Subject not found to be updated :(.");
            subjectRepository.save(subjectRO.toEntity(subjectOptional.get(), subjectOptional.get().getInstructor()));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(SUBJECT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
    
    @Override
    public void deleteSubject(Integer id) {
        try {
            Optional<Subject> subjectOptional = subjectRepository.findById(id);

            if (subjectOptional.isEmpty())
                throw new ResourceNotFoundException("Subject not found to be deleted :(.");

            subjectRepository.deleteById(id);
        } catch (Exception e) {
            String errorMessage = MessageUtils.deleteErrorMessage(SUBJECT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
}
