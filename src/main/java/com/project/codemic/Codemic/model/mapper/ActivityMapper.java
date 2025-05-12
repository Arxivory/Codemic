package com.project.codemic.Codemic.model.mapper;

import com.project.codemic.Codemic.model.dto.ActivityDTO;
import com.project.codemic.Codemic.model.entity.Activity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    ActivityDTO toDTO(Activity activity);
}
