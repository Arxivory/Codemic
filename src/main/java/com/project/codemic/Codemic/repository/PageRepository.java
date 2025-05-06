package com.project.codemic.Codemic.repository;

import com.project.codemic.Codemic.model.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, Integer> {
}
