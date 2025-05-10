package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Instructor;
import com.project.codemic.Codemic.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    // READ ONE
    @Override
    public Optional<Instructor> getInstructorById(Integer id) {
        return instructorRepository.findById(id);
    }

    // UPDATE
    @Override
    public Instructor updateInstructor(Integer id, Instructor instructor) {
        Optional<Instructor> existingInstructor = instructorRepository.findById(id);

        if (existingInstructor.isPresent()) {
            Instructor updatedInstructor = existingInstructor.get();
            updatedInstructor.setFirstName(instructor.getFirstName());
            updatedInstructor.setLastName(instructor.getLastName());
            updatedInstructor.setMiddleName(instructor.getMiddleName());
            updatedInstructor.setPassword(instructor.getPassword());
            updatedInstructor.setEmail(instructor.getEmail());
            return instructorRepository.save(updatedInstructor);
        }

        return null;
    }

    // DELETE
    @Override
    public void deleteInstructorById(Integer id) {
        instructorRepository.deleteById(id);
    }
}

