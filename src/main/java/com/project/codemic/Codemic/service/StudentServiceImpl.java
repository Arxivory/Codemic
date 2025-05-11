package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Integer id, Student studentDetails) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student updatedStudent = studentOptional.get();
            updatedStudent.setFirstName(studentDetails.getFirstName());
            updatedStudent.setMiddleName(studentDetails.getMiddleName());
            updatedStudent.setLastName(studentDetails.getLastName());
            updatedStudent.setEmail(studentDetails.getEmail());
            updatedStudent.setPassword(studentDetails.getPassword());
            updatedStudent.setProgram(studentDetails.getProgram());
            updatedStudent.setSection(studentDetails.getSection());
            updatedStudent.setYear(studentDetails.getYear());
        }

        return null;
    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent())
            studentRepository.deleteById(id);
    }
}
