package com.project.codemic.Codemic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students_subjects")
public class StudentSubject implements Serializable {

    @Serial
    private static final long serialVersionUID = 4871280281822347380L;

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

}
