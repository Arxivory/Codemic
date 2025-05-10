package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Testcase;
import com.project.codemic.Codemic.repository.TestcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestcaseServiceImpl implements TestcaseService {

    @Autowired
    private TestcaseRepository testcaseRepository;

    @Override
    public Testcase createTestcase(Testcase testcase) {
        return testcaseRepository.save(testcase);
    }

    @Override
    public List<Testcase> getAllTestcases() {
        return testcaseRepository.findAll();
    }

    @Override
    public Optional<Testcase> getTestcaseById(Integer id) {
        return testcaseRepository.findById(id);
    }

    @Override
    public Testcase updateTestcase(Integer id, Testcase testcaseDetails) {
        Optional<Testcase> existingTestcase = testcaseRepository.findById(id);

        if (existingTestcase.isPresent()) {
            Testcase updatedTestcase = existingTestcase.get();
            updatedTestcase.setInput(testcaseDetails.getInput());
            updatedTestcase.setOutput(testcaseDetails.getOutput());
            return testcaseRepository.save(updatedTestcase);
        }

        return null;
    }

    @Override
    public void deleteTestcase(Integer id) {
        testcaseRepository.deleteById(id);
    }
}
