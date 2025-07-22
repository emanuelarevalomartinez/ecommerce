package com.firstSpringBootProject.first.Category.infrastructure.adapters.output.persistence.repositories;

import com.firstSpringBootProject.first.Category.infrastructure.adapters.output.persistence.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
