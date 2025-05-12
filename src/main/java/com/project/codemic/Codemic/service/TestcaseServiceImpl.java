package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.exception.ResourceNotFoundException;
import com.project.codemic.Codemic.model.dto.TestcaseDTO;
import com.project.codemic.Codemic.model.entity.Activity;
import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.entity.Testcase;
import com.project.codemic.Codemic.model.mapper.TestcaseMapper;
import com.project.codemic.Codemic.model.request.TestcaseRO;
import com.project.codemic.Codemic.repository.TestcaseRepository;
import com.project.codemic.Codemic.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TestcaseServiceImpl implements TestcaseService {

    public static final String TESTCASES = "Testcase";

    public static final String TESTCASE = "Testcase";

    @Autowired
    private TestcaseRepository testcaseRepository;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private TestcaseMapper testcaseMapper;


    @Override
    public void createTestcase(TestcaseRO testcaseRO) {
        try {
            Activity activity = activityService.getActivityById(testcaseRO.activityId());

            testcaseRepository.save(testcaseRO.toEntity(null, activity));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(TESTCASE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public List<TestcaseDTO> getAllTestcases() {
        try {
            List<Testcase> testcases = testcaseRepository.findAll();
            log.info(MessageUtils.retrieveSuccessMessage(TESTCASES));
            return testcases.stream().map(testcaseMapper::toDTO).toList();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(TESTCASES);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public Testcase getTestcaseById(Integer id) {
        try {
            Optional<Testcase> testcaseOptional = testcaseRepository.findById(id);
            if (testcaseOptional.isEmpty())
                throw new Exception("Testcase not found.");

            log.info(MessageUtils.retrieveSuccessMessage(TESTCASE));
            return testcaseOptional.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(TESTCASE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void updateTestcase(Integer id, TestcaseRO testcaseRO) {
        try {
            Optional<Testcase> testcaseOptional = testcaseRepository.findById(id);
            if (testcaseOptional.isEmpty())
                throw new ResourceNotFoundException("Testcase not found to be updated :(.");
            testcaseRepository.save(testcaseRO.toEntity(testcaseOptional.get(), testcaseOptional.get().getActivity()));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(TESTCASE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void deleteTestcase(Integer id) {
        try {
            Optional<Testcase> testcaseOptional = testcaseRepository.findById(id);

            if (testcaseOptional.isEmpty())
                throw new ResourceNotFoundException("Testcase not found to be deleted :(.");

            testcaseRepository.deleteById(id);
        } catch (Exception e) {
            String errorMessage = MessageUtils.deleteErrorMessage(TESTCASE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
}
