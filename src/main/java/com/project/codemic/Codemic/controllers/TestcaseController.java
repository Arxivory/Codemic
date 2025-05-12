package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.request.StudentRO;
import com.project.codemic.Codemic.model.request.TestcaseRO;
import com.project.codemic.Codemic.service.StudentService;
import com.project.codemic.Codemic.service.TestcaseService;
import com.project.codemic.Codemic.util.MessageUtils;
import com.project.codemic.Codemic.util.ResponseUtils;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("codemic/testcase")
public class TestcaseController extends AbstractController {

    private TestcaseService testcaseService;

    @GetMapping
    public ResponseEntity<?> getAllTestcases() {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(TestcaseService.TESTCASES),
                        testcaseService.getAllTestcases()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestcaseById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(TestcaseService.TESTCASE),
                        testcaseService.getTestcaseById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> createTestcase(@Valid @RequestBody TestcaseRO testcaseRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        testcaseService.createTestcase(testcaseRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(TestcaseService.TESTCASE)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestcase(@PathVariable Integer id, @Valid @RequestBody TestcaseRO testcaseRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        testcaseService.updateTestcase(id, testcaseRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(TestcaseService.TESTCASE)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestcase(@PathVariable Integer id) {
        testcaseService.deleteTestcase(id);
        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(TestcaseService.TESTCASE)
                )
        );
    }

}
