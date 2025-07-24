package com.firstSpringBootProject.first.Product.application.usecases;

import com.firstSpringBootProject.first.Product.domain.exceptions.ErrorProductMessageCode;
import com.firstSpringBootProject.first.Product.domain.exceptions.ProductDomainException;
import com.firstSpringBootProject.first.Product.domain.models.Product;
import com.firstSpringBootProject.first.Product.domain.ports.in.FindProductByIdPort;
import com.firstSpringBootProject.first.Product.domain.ports.out.ProductRepositoryPort;

public class FindProductByIdUseCase implements FindProductByIdPort {

    private final ProductRepositoryPort productRepositoryPort;

    public FindProductByIdUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product findById(Long id) {
        return this.productRepositoryPort.findById(id)
                .orElseThrow(()-> new ProductDomainException(
                        ErrorProductMessageCode.PRODUCT_NOT_FOUND_ID.getStatus(),
                        ErrorProductMessageCode.PRODUCT_NOT_FOUND_ID.getType(),
                        String.format(ErrorProductMessageCode.PRODUCT_NOT_FOUND_ID.getMessage() + id),
                        null
                ));
    }
}
