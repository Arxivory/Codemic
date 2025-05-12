package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.exception.ResourceNotFoundException;
import com.project.codemic.Codemic.model.dto.InstructorDTO;
import com.project.codemic.Codemic.model.entity.Instructor;
import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.mapper.InstructorMapper;
import com.project.codemic.Codemic.model.request.InstructorRO;
import com.project.codemic.Codemic.repository.InstructorRepository;
import com.project.codemic.Codemic.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InstructorServiceImpl implements InstructorService {

    public static final String INSTRUCTORS = "Instructors";

    public static final String INSTRUCTOR = "Instructor";

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorMapper instructorMapper;

    @Override
    public void createInstructor(InstructorRO instructorRO) {
        try {
            instructorRepository.save(instructorRO.toEntity(null));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(INSTRUCTOR);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public List<InstructorDTO> getAllInstructors() {
        try {
            List<Instructor> instructors = instructorRepository.findAll();
            log.info(MessageUtils.retrieveSuccessMessage(INSTRUCTORS));
            return instructors.stream().map(instructorMapper::toDTO).toList();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(INSTRUCTORS);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        try {
            Optional<Instructor> instructorOptional = instructorRepository.findById(id);
            if (instructorOptional.isEmpty())
                throw new Exception("Instructor not found.");

            log.info(MessageUtils.retrieveSuccessMessage(INSTRUCTOR));
            return instructorOptional.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(INSTRUCTOR);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void updateInstructor(Integer id, InstructorRO instructorRO) {
        try {
            Optional<Instructor> instructorOptional = instructorRepository.findById(id);
            if (instructorOptional.isEmpty())
                throw new ResourceNotFoundException("Instructor not found to be updated :(.");
            instructorRepository.save(instructorRO.toEntity(instructorOptional.get()));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(INSTRUCTOR);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }


    @Override
    public void deleteInstructorById(Integer id) {
        try {
            Optional<Instructor> instructorOptional = instructorRepository.findById(id);

            if (instructorOptional.isEmpty())
                throw new ResourceNotFoundException("Instructor not found to be deleted :(.");

            instructorRepository.deleteById(id);
        } catch (Exception e) {
            String errorMessage = MessageUtils.deleteErrorMessage(INSTRUCTOR);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
}

