package com.project.codemic.Codemic.repository;

import com.project.codemic.Codemic.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository <Subject, Integer> {
}
