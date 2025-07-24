package com.firstSpringBootProject.first.Product.application.usecases;

import com.firstSpringBootProject.first.Product.domain.models.Product;
import com.firstSpringBootProject.first.Product.domain.ports.in.CreateProductPort;
import com.firstSpringBootProject.first.Product.domain.ports.out.ProductRepositoryPort;

public class CreateProductUseCase implements CreateProductPort {

    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product save(Product product) {
        return this.productRepositoryPort.save(product);
    }
}
