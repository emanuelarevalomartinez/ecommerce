package com.firstSpringBootProject.first.Category.application.usecases;

import com.firstSpringBootProject.first.Category.domain.models.Category;
import com.firstSpringBootProject.first.Category.domain.ports.in.CreateCategoryPort;
import com.firstSpringBootProject.first.Category.domain.ports.out.CategoryRepositoryPort;

public class CreateCategoryUseCase implements CreateCategoryPort {

    private final CategoryRepositoryPort categoryRepositoryPort;


    public CreateCategoryUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }


    @Override
    public Category save(Category category) {
        return this.categoryRepositoryPort.save(category);
    }
}
