package com.project.codemic.Codemic.model.dto;

import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSubjectDTO {
    private Integer id;
    private Student student;
    private Subject subject;
}
