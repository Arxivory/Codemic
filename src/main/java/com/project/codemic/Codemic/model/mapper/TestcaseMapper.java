package com.project.codemic.Codemic.model.mapper;

import com.project.codemic.Codemic.model.dto.TestcaseDTO;
import com.project.codemic.Codemic.model.entity.Testcase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestcaseMapper {
    TestcaseDTO toDTO(Testcase testcase);
}
