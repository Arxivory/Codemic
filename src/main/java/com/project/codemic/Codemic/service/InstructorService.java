package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    Instructor createInstructor(Instructor instructor);

    List<Instructor> getAllInstructors();

    Optional<Instructor> getInstructorById(Integer id);

    Instructor updateInstructor(Integer id, Instructor instructor);

    void deleteInstructorById(Integer id);
}
