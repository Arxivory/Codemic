package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.request.StudentRO;
import com.project.codemic.Codemic.model.request.SubmissionRO;
import com.project.codemic.Codemic.service.StudentService;
import com.project.codemic.Codemic.service.SubmissionService;
import com.project.codemic.Codemic.util.MessageUtils;
import com.project.codemic.Codemic.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("codemic/submission")
@RequiredArgsConstructor
public class SubmissionController extends AbstractController {

    private SubmissionService submissionService;

    @GetMapping
    public ResponseEntity<?> getAllSubmissions() {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(SubmissionService.SUBMISSIONS),
                        submissionService.getAllSubmissions()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubmissionById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(SubmissionService.SUBMISSION),
                        submissionService.getSubmissionById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> createSubmission(@Valid @RequestBody SubmissionRO submissionRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        submissionService.createSubmission(submissionRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(SubmissionService.SUBMISSION)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubmission(@PathVariable Integer id, @Valid @RequestBody SubmissionRO submissionRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        submissionService.updateSubmission(id, submissionRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(SubmissionService.SUBMISSION)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubmission(@PathVariable Integer id) {
        submissionService.deleteSubmission(id);
        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(SubmissionService.SUBMISSION)
                )
        );
    }

}
