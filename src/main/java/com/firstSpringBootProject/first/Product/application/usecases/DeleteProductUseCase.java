package com.firstSpringBootProject.first.Product.application.usecases;

import com.firstSpringBootProject.first.Category.domain.exceptions.CategoryDomainException;
import com.firstSpringBootProject.first.Category.domain.exceptions.ErrorCategoryMessageCode;
import com.firstSpringBootProject.first.Product.domain.exceptions.ErrorProductMessageCode;
import com.firstSpringBootProject.first.Product.domain.exceptions.ProductDomainException;
import com.firstSpringBootProject.first.Product.domain.ports.in.DeleteProductPort;
import com.firstSpringBootProject.first.Product.domain.ports.out.ProductRepositoryPort;

public class DeleteProductUseCase implements DeleteProductPort {

    private final ProductRepositoryPort productRepositoryPort;

    public DeleteProductUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public void deleteById(Long id) {

        boolean deleted = productRepositoryPort.deleteById(id);
        if (!deleted) {

            throw new ProductDomainException(
                    ErrorProductMessageCode.PRODUCT_NOT_FOUND_ID.getStatus(),
                    ErrorProductMessageCode.PRODUCT_NOT_FOUND_ID.getType(),
                    String.format(ErrorProductMessageCode.PRODUCT_NOT_FOUND_ID.getMessage() + id),
                    null
            );
        }

    }
}
