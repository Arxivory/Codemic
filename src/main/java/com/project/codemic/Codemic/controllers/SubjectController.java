package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.request.StudentRO;
import com.project.codemic.Codemic.model.request.SubjectRO;
import com.project.codemic.Codemic.service.StudentService;
import com.project.codemic.Codemic.service.SubjectService;
import com.project.codemic.Codemic.util.MessageUtils;
import com.project.codemic.Codemic.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("codemic/subjects")
@RequiredArgsConstructor
public class SubjectController extends AbstractController {

    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<?> getAllSubjects() {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(SubjectService.SUBJECTS),
                        subjectService.getAllSubjects()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(SubjectService.SUBJECT),
                        subjectService.getSubjectById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> createSubject (@Valid @RequestBody SubjectRO subjectRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        subjectService.createSubject(subjectRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(SubjectService.SUBJECT)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable Integer id, @Valid @RequestBody SubjectRO subjectRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        subjectService.updateSubject(id, subjectRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(SubjectService.SUBJECT)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Integer id) {
        subjectService.deleteSubject(id);
        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(SubjectService.SUBJECT)
                )
        );
    }
}
