package com.project.codemic.Codemic.model.dto;

import com.project.codemic.Codemic.model.entity.StudentSubject;
import com.project.codemic.Codemic.model.enums.Section;
import com.project.codemic.Codemic.model.enums.YearLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private YearLevel yearLevel;
    private Section section;
    private String program;
    private Set<StudentSubject> studentSubjects;

}
