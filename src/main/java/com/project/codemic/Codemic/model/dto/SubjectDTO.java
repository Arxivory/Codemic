package com.project.codemic.Codemic.model.dto;

import com.project.codemic.Codemic.model.entity.Activity;
import com.project.codemic.Codemic.model.entity.Instructor;
import com.project.codemic.Codemic.model.entity.StudentSubject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    private Integer id;
    private String title;
    private String code;
    private Instructor instructor;
    private Set<StudentSubject> studentSubjects;
    private Set<Module> modules;
    private Set<Activity> activities;

}
