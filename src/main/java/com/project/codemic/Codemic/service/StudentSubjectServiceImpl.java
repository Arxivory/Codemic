package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.StudentSubject;
import com.project.codemic.Codemic.repository.StudentSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {

    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

    @Override
    public StudentSubject createStudentSubject(StudentSubject studentSubject) {
        return studentSubjectRepository.save(studentSubject);
    }

    @Override
    public List<StudentSubject> getAllStudentSubjects() {
        return studentSubjectRepository.findAll();
    }

    @Override
    public Optional<StudentSubject> getStudentSubjectById(Integer id) {
        return studentSubjectRepository.findById(id);
    }

    @Override
    public StudentSubject updateStudentSubject(Integer id, StudentSubject studentSubjectDetails) {
        Optional<StudentSubject> studentSubjectOptional = studentSubjectRepository.findById(id);

        if (studentSubjectOptional.isPresent()) {
            StudentSubject updatedStudentSubject = studentSubjectOptional.get();
            updatedStudentSubject.setStudent(studentSubjectDetails.getStudent());
            updatedStudentSubject.setSubject(studentSubjectDetails.getSubject());
            return studentSubjectRepository.save(updatedStudentSubject);
        }
        return null;
    }

    @Override
    public void deleteStudentSubject(Integer id) {
        studentSubjectRepository.deleteById(id);
    }
}
