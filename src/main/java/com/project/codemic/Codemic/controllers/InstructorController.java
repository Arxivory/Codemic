package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.entity.Instructor;
import com.project.codemic.Codemic.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/codemic/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.createInstructor(instructor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return new ResponseEntity<>(instructorService.getAllInstructors(), HttpStatus.OK);
    }

    public ResponseEntity<Instructor> getInstructorById(@PathVariable Integer id) {
        return instructorService.getInstructorById(id)
                .map(instructor -> ResponseEntity.ok(instructor))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Integer id, Instructor instructorDetails) {
        Instructor updatedInstructor = instructorService.updateInstructor(id, instructorDetails);
        return updatedInstructor != null ? ResponseEntity.ok(updatedInstructor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instructor> deleteInstructor(@PathVariable Integer id) {
        return instructorService.getInstructorById(id)
                .map(page -> {
                    instructorService.deleteInstructorById(id);
                    return ResponseEntity.ok(page);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}