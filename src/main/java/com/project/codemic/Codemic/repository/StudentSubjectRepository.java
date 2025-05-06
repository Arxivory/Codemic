package com.project.codemic.Codemic.repository;

import com.project.codemic.Codemic.model.entity.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
}
