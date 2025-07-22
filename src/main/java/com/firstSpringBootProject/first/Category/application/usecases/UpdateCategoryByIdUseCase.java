package com.firstSpringBootProject.first.Category.application.usecases;

import com.firstSpringBootProject.first.Category.domain.models.Category;
import com.firstSpringBootProject.first.Category.domain.ports.in.UpdateCategoryPort;
import com.firstSpringBootProject.first.Category.domain.ports.out.CategoryRepositoryPort;

public class UpdateCategoryByIdUseCase implements UpdateCategoryPort {

    private final CategoryRepositoryPort categoryRepositoryPort;

    public UpdateCategoryByIdUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public Category update(Long id, Category category) {
        return this.categoryRepositoryPort.update(id, category);
    }
}
