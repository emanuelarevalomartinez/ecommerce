package com.firstSpringBootProject.first.Category.infrastructure.adapters.output.persistence.repositories;

import com.firstSpringBootProject.first.Category.infrastructure.adapters.output.persistence.entities.CategoryEntity;
import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
