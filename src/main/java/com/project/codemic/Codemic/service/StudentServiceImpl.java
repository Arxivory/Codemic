package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.exception.ResourceNotFoundException;
import com.project.codemic.Codemic.model.dto.StudentDTO;
import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.mapper.StudentMapper;
import com.project.codemic.Codemic.model.request.StudentRO;
import com.project.codemic.Codemic.repository.StudentRepository;
import com.project.codemic.Codemic.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    public static final String STUDENTS = "Students";

    public static final String STUDENT = "Student";

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void createStudent(StudentRO studentRO) {
        try {
            studentRepository.save(studentRO.toEntity(null));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(STUDENT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        try {
            List<Student> students = studentRepository.findAll();
            log.info(MessageUtils.retrieveSuccessMessage(STUDENTS));
            return students.stream().map(studentMapper::toDTO).toList();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(STUDENTS);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public Student getStudentById(Integer id) {
        try {
            Optional<Student> studentOptional = studentRepository.findById(id);
            if (studentOptional.isEmpty())
                throw new Exception("Student not found.");

            log.info(MessageUtils.retrieveSuccessMessage(STUDENT));
            return studentOptional.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(STUDENT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void updateStudent(Integer id, StudentRO studentRO) {
        try {
            Optional<Student> studentOptional = studentRepository.findById(id);
            if (studentOptional.isEmpty())
                throw new ResourceNotFoundException("Student not found to be updated :(.");
            studentRepository.save(studentRO.toEntity(studentOptional.get()));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(STUDENT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void deleteStudent(Integer id) {
        try {
            Optional<Student> studentOptional = studentRepository.findById(id);

            if (studentOptional.isEmpty())
                throw new ResourceNotFoundException("Student not found to be deleted :(.");

            studentRepository.deleteById(id);
        } catch (Exception e) {
            String errorMessage = MessageUtils.deleteErrorMessage(STUDENT);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
}
