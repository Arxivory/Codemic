package com.project.codemic.Codemic.repository;

import com.project.codemic.Codemic.model.entity.Testcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestcaseRepository extends JpaRepository<Testcase, Integer> {
}
