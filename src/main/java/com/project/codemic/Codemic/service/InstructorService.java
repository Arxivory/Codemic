package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.dto.InstructorDTO;
import com.project.codemic.Codemic.model.entity.Instructor;
import com.project.codemic.Codemic.model.request.InstructorRO;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    void createInstructor(InstructorRO instructorRO);

    List<InstructorDTO> getAllInstructors();

    Instructor getInstructorById(Integer id);

    void updateInstructor(Integer id, InstructorRO instructorRO);

    void deleteInstructorById(Integer id);
}
