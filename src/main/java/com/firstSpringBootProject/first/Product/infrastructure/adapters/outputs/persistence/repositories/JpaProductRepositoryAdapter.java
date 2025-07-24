package com.firstSpringBootProject.first.Product.infrastructure.adapters.outputs.persistence.repositories;

import com.firstSpringBootProject.first.Product.domain.models.Product;
import com.firstSpringBootProject.first.Product.domain.ports.out.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;

public class JpaProductRepositoryAdapter implements ProductRepositoryPort {

// TODO me quede implementando todos estos metodos y me falta la carpeta inputs con todo dentro y probarlo todo


    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Product update(Long id, Product product) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
