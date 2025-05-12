package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.request.InstructorRO;
import com.project.codemic.Codemic.service.InstructorService;
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
@RequestMapping("codemic/instructor")
@RequiredArgsConstructor
public class InstructorController extends AbstractController {

    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<?> getAllInstructors() {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(InstructorService.INSTRUCTORS),
                        instructorService.getAllInstructors()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(InstructorService.INSTRUCTOR),
                        instructorService.getInstructorById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> createInstructor(@Valid @RequestBody InstructorRO instructorRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        instructorService.createInstructor(instructorRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(InstructorService.INSTRUCTOR)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstructor(@PathVariable Integer id, @Valid @RequestBody InstructorRO instructorRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        instructorService.updateInstructor(id, instructorRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(InstructorService.INSTRUCTOR)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable Integer id) {
        instructorService.deleteInstructor(id);
        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(InstructorService.INSTRUCTOR)
                )
        );
    }

}
