package com.project.codemic.Codemic.model.mapper;

import com.project.codemic.Codemic.model.dto.InstructorDTO;
import com.project.codemic.Codemic.model.entity.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorDTO toDTO(Instructor instructor);
}
