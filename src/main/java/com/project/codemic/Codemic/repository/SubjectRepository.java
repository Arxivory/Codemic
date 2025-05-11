package com.project.codemic.Codemic.repository;

import com.project.codemic.Codemic.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository <Subject, Integer> {
  
    Optional<Subject> findByName(String name);
    
    List<Subject> findByCreditsGreaterThanEqual(Integer credits);
    
    List<Subject> findByNameContainingIgnoreCase(String keyword);
    
    boolean existsByName(String name);
}
