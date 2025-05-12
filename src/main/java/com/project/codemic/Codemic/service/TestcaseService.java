package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.dto.TestcaseDTO;
import com.project.codemic.Codemic.model.entity.Testcase;
import com.project.codemic.Codemic.model.request.TestcaseRO;

import java.util.List;
import java.util.Optional;

public interface TestcaseService {
    void createTestcase(TestcaseRO testcaseRO);

    List<TestcaseDTO> getAllTestcases();

    Testcase getTestcaseById(Integer id);

    void updateTestcase(Integer id, TestcaseRO testcaseRO);

    void deleteTestcase(Integer id);
}
