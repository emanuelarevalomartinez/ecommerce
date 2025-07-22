package com.firstSpringBootProject.first.Category.domain.ports.out;

import com.firstSpringBootProject.first.Category.domain.models.Category;
import com.firstSpringBootProject.first.User.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {

    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Category update(Long id,Category category);

    boolean deleteById(Long id);

}
