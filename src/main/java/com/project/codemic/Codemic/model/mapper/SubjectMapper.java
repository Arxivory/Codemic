package com.project.codemic.Codemic.model.mapper;

import com.project.codemic.Codemic.model.dto.SubjectDTO;
import com.project.codemic.Codemic.model.entity.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectDTO toDTO(Subject subject);
}
