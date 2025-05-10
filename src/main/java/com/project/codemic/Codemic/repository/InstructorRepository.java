package com.project.codemic.Codemic.repository;

import com.project.codemic.Codemic.model.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
