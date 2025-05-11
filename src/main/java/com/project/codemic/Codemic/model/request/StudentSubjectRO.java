package com.project.codemic.Codemic.model.request;

import java.util.Objects;

import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.entity.StudentSubject;
import com.project.codemic.Codemic.model.entity.Subject;

import jakarta.validation.constraints.NotNull;

public record StudentSubjectRO(
    Integer id,
    
    @NotNull(message = "Student ID is mandatory.")
    Integer studentId,
    
    @NotNull(message = "Subject ID is mandatory.")
    Integer subjectId
) {

    public StudentSubject toEntity(StudentSubject studentSubject, Student student, Subject subject) {
        if (Objects.isNull(studentSubject)) {
            studentSubject = new StudentSubject();
        }
        
        studentSubject.setStudent(student);
        studentSubject.setSubject(subject);
        
        return studentSubject;
    }
}
