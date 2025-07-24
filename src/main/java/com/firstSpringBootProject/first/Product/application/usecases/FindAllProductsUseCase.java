package com.firstSpringBootProject.first.Product.application.usecases;

import com.firstSpringBootProject.first.Product.domain.models.Product;
import com.firstSpringBootProject.first.Product.domain.ports.in.FindAllProductsPort;
import com.firstSpringBootProject.first.Product.domain.ports.out.ProductRepositoryPort;

import java.util.List;

public class FindAllProductsUseCase implements FindAllProductsPort {

    private final ProductRepositoryPort productRepositoryPort;

    public FindAllProductsUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepositoryPort.findAll();
    }
}
