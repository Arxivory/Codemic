package com.project.codemic.Codemic.controller;

import com.project.codemic.Codemic.model.entity.Instructor;
import com.project.codemic.Codemic.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }


    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }


    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable Integer id) {
        return instructorService.getInstructorById(id);
    }


    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable Integer id, @RequestBody Instructor instructor) {
        return instructorService.updateInstructor(id, instructor);
    }


    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Integer id) {
        instructorService.deleteInstructor(id);
    }
}
