package com.project.codemic.Codemic.model.request;

import com.project.codemic.Codemic.model.entity.Activity;
import com.project.codemic.Codemic.model.entity.Testcase;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TestcaseRO(
        Integer id,
        @NotBlank(message = "Testcase input is mandatory") String input,
        @NotBlank(message = "Testcase output is mandatory") String output,
        @NotNull(message = "Activity ID is mandatory") Integer activityId
) {

    public Testcase toEntity(Testcase testcase, Activity activity) {
        if (testcase == null) {
            testcase = new Testcase();
        }

        testcase.setInput(input);
        testcase.setOutput(output);
        testcase.setActivity(activity);

        return testcase;
    }
}
