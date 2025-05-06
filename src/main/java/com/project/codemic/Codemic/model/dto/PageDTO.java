package com.project.codemic.Codemic.model.dto;

import com.project.codemic.Codemic.model.entity.Module;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO {
    private Integer id;
    private String content;
    private Module module;
}
