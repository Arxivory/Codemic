package com.project.codemic.Codemic.model.request;

import java.util.Date;
import java.util.Objects;

import com.project.codemic.Codemic.model.entity.Page;
import com.project.codemic.Codemic.model.entity.Subject;
import com.project.codemic.Codemic.util.DateUtils;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PageRO(
    Long id,
    @NotBlank(message = "Title is mandatory.") 
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters skrt eme.")
    String title,
    
    @NotBlank(message = "Content is mandatory.")
    String content,
    
    Date createdDate,
    
    @NotNull(message = "Subject ID is mandatory.") 
    Integer subjectId
) {

    public Page toEntity(Page page, Subject subject) {
        if (Objects.isNull(page)) {
            page = new Page();
        }
        
        page.setTitle(title);
        page.setContent(content);
        page.setCreatedDate(Objects.isNull(createdDate) ? DateUtils.now() : createdDate);
        page.setSubject(subject);

        return page;
    }
}
