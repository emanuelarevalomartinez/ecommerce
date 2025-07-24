package com.firstSpringBootProject.first.Category.domain.ports.out;

import com.firstSpringBootProject.first.Category.domain.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {

    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Optional<Category> findByName(String name);

    Category update(Long id,Category category);

    boolean deleteById(Long id);

}
