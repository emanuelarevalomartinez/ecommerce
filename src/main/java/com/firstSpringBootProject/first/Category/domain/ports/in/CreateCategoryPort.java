package com.firstSpringBootProject.first.Category.domain.ports.in;

import com.firstSpringBootProject.first.Category.domain.models.Category;

public interface CreateCategoryPort {
    Category save(Category category);
}
