package com.project.codemic.Codemic.model.entity;

import com.project.codemic.Codemic.converter.YearLevelConverter;
import com.project.codemic.Codemic.model.enums.Section;
import com.project.codemic.Codemic.model.enums.YearLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = -6757061438334934681L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name", nullable = false)
    private Character middleName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Convert(converter = YearLevelConverter.class)
    @Column(name = "year", nullable = false)
    private YearLevel year;

    @Enumerated(EnumType.STRING)
    @Column(name = "section",nullable = false)
    private Section section;

    @Column(name = "program", nullable = false)
    private String program;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentSubject> studentSubjects;

}
