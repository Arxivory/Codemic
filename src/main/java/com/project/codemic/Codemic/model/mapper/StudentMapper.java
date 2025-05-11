package com.project.codemic.Codemic.model.mapper;

import com.project.codemic.Codemic.model.dto.StudentDTO;
import com.project.codemic.Codemic.model.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDTO(Student student);
}
