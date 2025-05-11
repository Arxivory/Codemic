package com.project.codemic.Codemic.model.request;

import java.util.Objects;

import com.project.codemic.Codemic.model.entity.Module;
import com.project.codemic.Codemic.model.entity.Subject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModuleRO(
    Integer id,
    @NotBlank(message = "Title is mandatory.") String title,
    @NotNull(message = "Subject ID is mandatory.") Integer subjectId
) {

    public Module toEntity(Module module, Subject subject) {
        if (Objects.isNull(module)) {
            module = new Module();
        }
        
        module.setTitle(title);
        module.setSubject(subject);
        
        return module;
    }
}
