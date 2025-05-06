package com.project.codemic.Codemic.model.dto;

import com.project.codemic.Codemic.model.entity.Subject;
import com.project.codemic.Codemic.model.entity.Submission;
import com.project.codemic.Codemic.model.entity.Testcase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {

    private Integer id;
    private String title;
    private String content;
    private Subject subject;
    private Set<Testcase> testcases;
    private Set<Submission> submissions;

}
