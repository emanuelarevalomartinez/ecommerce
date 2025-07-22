package com.firstSpringBootProject.first.Category.domain.ports.in;

import com.firstSpringBootProject.first.Category.domain.models.Category;

import java.util.Optional;

public interface FindCategoryByIdPort {
    Category findById(Long id);
}
