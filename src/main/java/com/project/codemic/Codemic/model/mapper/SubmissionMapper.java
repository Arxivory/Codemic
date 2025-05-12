package com.project.codemic.Codemic.model.mapper;

import com.project.codemic.Codemic.model.dto.SubmissionDTO;
import com.project.codemic.Codemic.model.entity.Submission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {
    SubmissionDTO toDTO(Submission submission);
}
