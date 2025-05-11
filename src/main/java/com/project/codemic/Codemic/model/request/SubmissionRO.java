package com.project.codemic.Codemic.model.request;

import java.util.Objects;

import com.project.codemic.Codemic.model.entity.Activity;
import com.project.codemic.Codemic.model.entity.Submission;
import com.project.codemic.Codemic.model.enums.TimeComplexity;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SubmissionRO(
    Integer id,
    @NotBlank(message = "Code is mandatory.") String code,
    @NotNull(message = "Time complexity is mandatory.") TimeComplexity timeComplexity,
    @DecimalMin(value = "0.0", message = "Grade must be a positive number.") double grade,
    @NotNull(message = "Activity ID is mandatory.") Integer activityId
) {

    public Submission toEntity(Submission submission, Activity activity) {
        if (Objects.isNull(submission)) {
            submission = new Submission();
        }
        
        submission.setCode(code);
        submission.setTimeComplexity(timeComplexity);
        submission.setGrade(grade);
        submission.setActivity(activity);
        

        return submission;
    }
}
