package com.firstSpringBootProject.first.Category.application.usecases;

import com.firstSpringBootProject.first.Category.domain.exceptions.CategoryDomainException;
import com.firstSpringBootProject.first.Category.domain.exceptions.ErrorCategoryMessageCode;
import com.firstSpringBootProject.first.Category.domain.ports.in.DeleteCategoryPort;
import com.firstSpringBootProject.first.Category.domain.ports.out.CategoryRepositoryPort;

public class DeleteCategoryUseCase implements DeleteCategoryPort {

    private final CategoryRepositoryPort categoryRepositoryPort;


    public DeleteCategoryUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }


    @Override
    public void deleteById(Long id) {

        boolean deleted = categoryRepositoryPort.deleteById(id);
        if (!deleted) {

            throw new CategoryDomainException(
                    ErrorCategoryMessageCode.CATEGORY_NOT_FOUND_ID.getStatus(),
                    ErrorCategoryMessageCode.CATEGORY_NOT_FOUND_ID.getType(),
                    String.format(ErrorCategoryMessageCode.CATEGORY_NOT_FOUND_ID.getMessage(), id),
                    null
            );
        }


    }
}
