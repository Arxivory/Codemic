package com.project.codemic.Codemic.model.request;

import com.project.codemic.Codemic.model.entity.Activity;
import com.project.codemic.Codemic.model.entity.Subject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActivityRO(
        Integer id,
        @NotBlank(message = "Activity title is mandatory.") String title,
        @NotBlank(message = "Activity content is mandatory.") String content,
        @NotNull(message = "Subject ID id mandatory") Integer subjectId
) {
    public Activity toEntity(Activity activity, Subject subject) {
        if (activity == null) {
            activity = new Activity();
        }

        activity.setTitle(title);
        activity.setContent(content);
        activity.setSubject(subject);

        return activity;
    }
}
