package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.exception.ResourceNotFoundException;
import com.project.codemic.Codemic.model.dto.StudentSubjectDTO;
import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.entity.StudentSubject;
import com.project.codemic.Codemic.model.entity.Subject;
import com.project.codemic.Codemic.model.mapper.StudentSubjectMapper;
import com.project.codemic.Codemic.model.request.StudentRO;
import com.project.codemic.Codemic.model.request.StudentSubjectRO;
import com.project.codemic.Codemic.model.request.SubjectRO;
import com.project.codemic.Codemic.repository.StudentSubjectRepository;
import com.project.codemic.Codemic.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {

    public static final String STUDENTSUBJECTS = "StudentSubjects";

    public static final String STUDENTSUBJECT = "StudentSubject";

    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentSubjectMapper studentSubjectMapper;

    @Override
    public void createStudentSubject(StudentSubjectRO studentSubjectRO) {
        try {
            Student student = studentService.getStudentById(studentSubjectRO.studentId());
            Subject subject = subjectService.getSubjectById(studentSubjectRO.subjectId());

            StudentSubject studentSubject = new StudentSubject();
            studentSubject.setStudent(student);
            studentSubject.setSubject(subject);

            studentSubjectRepository.save(studentSubject);
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(STUDENTSUBJECT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public List<StudentSubjectDTO> getAllStudentSubjects() {
        try {
            List<StudentSubject> studentSubjects = studentSubjectRepository.findAll();
            log.info(MessageUtils.retrieveSuccessMessage(STUDENTSUBJECTS));
            return studentSubjects.stream().map(studentSubjectMapper::toDTO).toList();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(STUDENTSUBJECTS);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public StudentSubject getStudentSubjectById(Integer id) {
        try {
            Optional<StudentSubject> studentSubjectOptional = studentSubjectRepository.findById(id);
            if (studentSubjectOptional.isEmpty())
                throw new Exception("Student Subject not found.");

            log.info(MessageUtils.retrieveSuccessMessage(STUDENTSUBJECT));
            return studentSubjectOptional.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(STUDENTSUBJECT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void updateStudentSubject(Integer id, StudentSubjectRO studentSubjectRO) {
        try {
            Optional<StudentSubject> studentSubjectOptional = studentSubjectRepository.findById(id);
            if (studentSubjectOptional.isEmpty())
                throw new ResourceNotFoundException("Student Subject not found to be updated :(.");
            studentSubjectRepository.save(studentSubjectRO.toEntity(studentSubjectOptional.get(),
                    studentSubjectOptional.get().getStudent(),
                    studentSubjectOptional.get().getSubject()));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(STUDENTSUBJECT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void deleteStudentSubject(Integer id) {
        try {
            Optional<StudentSubject> studentSubjectOptional = studentSubjectRepository.findById(id);

            if (studentSubjectOptional.isEmpty())
                throw new ResourceNotFoundException("Student Subject not found to be deleted :(.");

            studentSubjectRepository.deleteById(id);
        } catch (Exception e) {
            String errorMessage = MessageUtils.deleteErrorMessage(STUDENTSUBJECT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
}
