package com.project.codemic.Codemic.model.request;

import com.project.codemic.Codemic.model.entity.Instructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record InstructorRO(
        Integer id,

        @NotBlank(message = "First name is mandatory.")
        String firstName,

        @NotBlank(message = "Last name is mandatory.")
        String lastName,

        @NotNull(message = "Middle name initial is mandatory.")
        String middleName,

        @NotBlank(message = "Email is mandatory.")
        @Email(message = "Email should be valid.")
        String email,

        @NotBlank(message = "Password is mandatory.")
        @Size(min = 8, message = "Password must be at least 8 characters long.")
        String password
) {

    public Instructor toEntity(Instructor instructor) {
        if (instructor == null) {
            instructor = new Instructor();
        }

        instructor.setFirstName(firstName);
        instructor.setMiddleName(middleName);
        instructor.setLastName(lastName);
        instructor.setEmail(email);
        instructor.setEmail(password);

        return instructor;
    }
}
