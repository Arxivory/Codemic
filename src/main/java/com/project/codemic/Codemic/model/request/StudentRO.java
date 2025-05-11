package com.project.codemic.Codemic.model.request;

import java.util.Objects;

import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.enums.Section;
import com.project.codemic.Codemic.model.enums.YearLevel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record StudentRO(
    Integer id,
    
    @NotBlank(message = "First name is mandatory.")
    String firstName,
    
    @NotBlank(message = "Last name is mandatory.")
    String lastName,
    
    @NotNull(message = "Middle name initial is mandatory.")
    Character middleName,
    
    @NotBlank(message = "Email is mandatory.")
    @Email(message = "Email should be valid.")
    String email,
    
    @NotBlank(message = "Password is mandatory.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    String password,
    
    @NotNull(message = "Year level is mandatory.")
    YearLevel year,
    
    @NotNull(message = "Section is mandatory.")
    Section section,
    
    @NotBlank(message = "Program is mandatory.")
    String program
) {

    public Student toEntity(Student student) {
        if (Objects.isNull(student)) {
            student = new Student();
        }
        
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setMiddleName(middleName);
        student.setEmail(email);
        student.setPassword(password);
        student.setYear(year);
        student.setSection(section);
        student.setProgram(program);
        
        
        return student;
    }
}
