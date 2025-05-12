package com.project.codemic.Codemic.model.mapper;

import com.project.codemic.Codemic.model.dto.PageDTO;
import com.project.codemic.Codemic.model.entity.Page;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PageMapper {
    PageDTO toDTO(Page page);
}
