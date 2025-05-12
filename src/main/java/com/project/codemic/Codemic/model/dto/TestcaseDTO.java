package com.project.codemic.Codemic.model.dto;

import com.project.codemic.Codemic.model.entity.Activity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestcaseDTO {
    private Integer id;
    private String input;
    private String output;
    private Activity activity;
}
