package com.project.codemic.Codemic.model.request;

import java.util.Objects;

import com.project.codemic.Codemic.model.entity.Subject;
import com.project.codemic.Codemic.model.entity.Instructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SubjectRO(
    Integer id,
    
    @NotBlank(message = "Subject title is mandatory.")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters.")
    String title,
    
    @NotBlank(message = "Subject code is mandatory.")
    @Pattern(regexp = "^[A-Z]{2,4}\\d{3,4}$", message = "Subject code must be in format like 'CS101' or 'MATH2001'")
    String code,
    
    @NotNull(message = "Instructor ID is mandatory.")
    Integer instructorId
) {

    public Subject toEntity(Subject subject, Instructor instructor) {
        if (Objects.isNull(subject)) {
            subject = new Subject();
        }
        
        subject.setTitle(title);
        subject.setCode(code);
        subject.setInstructor(instructor);
        
        return subject;
    }
}
