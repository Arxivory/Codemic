package com.project.codemic.Codemic.model.mapper;

import com.project.codemic.Codemic.model.dto.StudentSubjectDTO;
import com.project.codemic.Codemic.model.entity.StudentSubject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentSubjectMapper {
    StudentSubjectDTO toDTO(StudentSubject studentSubject);
}
