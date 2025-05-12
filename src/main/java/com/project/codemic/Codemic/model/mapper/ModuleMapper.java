package com.project.codemic.Codemic.model.mapper;

import com.project.codemic.Codemic.model.dto.ModuleDTO;
import org.mapstruct.Mapper;
import com.project.codemic.Codemic.model.entity.Module;

@Mapper(componentModel = "spring")
public interface ModuleMapper {
    ModuleDTO toDTO(Module module);
}
