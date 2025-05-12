package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.dto.InstructorDTO;
import com.project.codemic.Codemic.model.entity.Instructor;
import com.project.codemic.Codemic.model.request.InstructorRO;

import java.util.List;

public interface InstructorService {
    String INSTRUCTORS = "Instructors";

    String INSTRUCTOR = "Instructor";

    void createInstructor(InstructorRO instructorRO);

    List<InstructorDTO> getAllInstructors();

    Instructor getInstructorById(Integer id);

    void updateInstructor(Integer id, InstructorRO instructorRO);

    void deleteInstructor(Integer id);
}
