package com.project.codemic.Codemic.model.request;

import java.util.Objects;

import com.project.codemic.Codemic.model.entity.Module;
import com.project.codemic.Codemic.model.entity.Page;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PageRO(
    Integer id,
    @NotBlank(message = "Content is mandatory.") String content,
    @NotNull(message = "Module ID is mandatory.") Integer moduleId
) {

    public Page toEntity(Page page, Module module) {
        if (Objects.isNull(page)) {
            page = new Page();
        }
        
        page.setContent(content);
        page.setModule(module);
        return page;
    }
}
