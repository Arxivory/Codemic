package com.project.codemic.Codemic.model.dto;

import com.project.codemic.Codemic.model.entity.Activity;
import com.project.codemic.Codemic.model.enums.TimeComplexity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionDTO {

    private Integer id;
    private String code;
    private TimeComplexity timeComplexity;
    private double grade;
    private LocalDateTime dateTime;
    private Activity activity;
}
