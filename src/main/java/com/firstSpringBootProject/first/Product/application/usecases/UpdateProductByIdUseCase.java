package com.firstSpringBootProject.first.Product.application.usecases;

import com.firstSpringBootProject.first.Product.domain.models.Product;
import com.firstSpringBootProject.first.Product.domain.ports.in.UpdateProductPort;
import com.firstSpringBootProject.first.Product.domain.ports.out.ProductRepositoryPort;

public class UpdateProductByIdUseCase implements UpdateProductPort {

    private final ProductRepositoryPort productRepositoryPort;

    public UpdateProductByIdUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product update(Long id, Product product) {
        return this.productRepositoryPort.update(id, product);
    }
}
