package com.project.codemic.Codemic.model.dto;

import com.project.codemic.Codemic.model.entity.Page;
import com.project.codemic.Codemic.model.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {

    private Integer id;
    private String title;
    private Subject subject;
    private Set<Page> pages;

}
