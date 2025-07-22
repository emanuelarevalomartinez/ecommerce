package com.firstSpringBootProject.first.Category.application.usecases;

import com.firstSpringBootProject.first.Category.domain.exceptions.CategoryDomainException;
import com.firstSpringBootProject.first.Category.domain.exceptions.ErrorCategoryMessageCode;
import com.firstSpringBootProject.first.Category.domain.models.Category;
import com.firstSpringBootProject.first.Category.domain.ports.in.FindCategoryByIdPort;
import com.firstSpringBootProject.first.Category.domain.ports.out.CategoryRepositoryPort;

public class FindCategoryByIdUsecase implements FindCategoryByIdPort {


    private final CategoryRepositoryPort categoryRepositoryPort;

    public FindCategoryByIdUsecase(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepositoryPort.findById(id)
                .orElseThrow(()-> new CategoryDomainException(
                        ErrorCategoryMessageCode.CATEGORY_NOT_FOUND_ID.getStatus(),
                        ErrorCategoryMessageCode.CATEGORY_NOT_FOUND_ID.getType(),
                        String.format(ErrorCategoryMessageCode.CATEGORY_NOT_FOUND_ID.getMessage(), id),
                        null
                ));
    }
}
