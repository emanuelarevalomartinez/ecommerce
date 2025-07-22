package com.firstSpringBootProject.first.Category.domain.ports.in;

import com.firstSpringBootProject.first.Category.domain.models.Category;

public interface UpdateCategoryPort {
    Category update(Long id, Category category);
}
