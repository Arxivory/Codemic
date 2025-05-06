package com.project.codemic.Codemic.model.dto;

import com.project.codemic.Codemic.model.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private Set<Subject> subjects;

}
