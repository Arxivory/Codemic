package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.request.StudentRO;
import com.project.codemic.Codemic.model.request.StudentSubjectRO;
import com.project.codemic.Codemic.service.StudentService;
import com.project.codemic.Codemic.service.StudentSubjectService;
import com.project.codemic.Codemic.util.MessageUtils;
import com.project.codemic.Codemic.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("codemic/studentsubject")
@RequiredArgsConstructor
public class StudentSubjectController extends AbstractController {

    private StudentSubjectService studentSubjectService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(StudentSubjectService.STUDENTSUBJECTS),
                        studentSubjectService.getAllStudentSubjects()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentSubjectById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(StudentSubjectService.STUDENTSUBJECT),
                        studentSubjectService.getStudentSubjectById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> createStudentSubject(@Valid @RequestBody StudentSubjectRO studentSubjectRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        studentSubjectService.createStudentSubject(studentSubjectRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(StudentSubjectService.STUDENTSUBJECT)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudentSubject(@PathVariable Integer id, @Valid @RequestBody StudentSubjectRO studentSubjectRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        studentSubjectService.updateStudentSubject(id, studentSubjectRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(StudentSubjectService.STUDENTSUBJECT)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentSubject(@PathVariable Integer id) {
        studentSubjectService.deleteStudentSubject(id);
        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(StudentSubjectService.STUDENTSUBJECT)
                )
        );
    }

}
