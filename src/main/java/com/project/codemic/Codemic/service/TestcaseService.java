package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Testcase;

import java.util.List;
import java.util.Optional;

public interface TestcaseService {
    Testcase createTestcase(Testcase testcase);

    List<Testcase> getAllTestcases();

    Optional<Testcase> getTestcaseById(Integer id);

    Testcase updateTestcase(Integer id, Testcase testcase);

    void deleteTestcase(Integer id);
}
