package com.project.codemic.Codemic.repository;

import com.project.codemic.Codemic.model.entity.Instructor;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaAttributeConverter<Instructor, Integer> {
}
