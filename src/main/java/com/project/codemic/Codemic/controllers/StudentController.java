package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.request.StudentRO;
import com.project.codemic.Codemic.service.StudentService;
import com.project.codemic.Codemic.util.MessageUtils;
import com.project.codemic.Codemic.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("codemic/student")
@RequiredArgsConstructor
public class StudentController extends AbstractController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(StudentService.STUDENTS),
                        studentService.getAllStudents()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(StudentService.STUDENT),
                        studentService.getStudentById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentRO studentRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        studentService.createStudent(studentRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(StudentService.STUDENT)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentRO studentRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        studentService.updateStudent(id, studentRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(StudentService.STUDENT)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(StudentService.STUDENT)
                )
        );
    }

}
