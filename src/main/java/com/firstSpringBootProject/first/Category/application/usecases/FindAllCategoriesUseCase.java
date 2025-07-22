package com.firstSpringBootProject.first.Category.application.usecases;

import com.firstSpringBootProject.first.Category.domain.models.Category;
import com.firstSpringBootProject.first.Category.domain.ports.in.FindAllCategoriesPort;
import com.firstSpringBootProject.first.Category.domain.ports.out.CategoryRepositoryPort;

import java.util.List;

public class FindAllCategoriesUseCase implements FindAllCategoriesPort {

    private final CategoryRepositoryPort categoryRepositoryPort;


    public FindAllCategoriesUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }


    @Override
    public List<Category> findAll() {
        return this.categoryRepositoryPort.findAll();
    }
}
