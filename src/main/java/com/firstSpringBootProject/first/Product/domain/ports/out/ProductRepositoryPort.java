package com.firstSpringBootProject.first.Product.domain.ports.out;

import com.firstSpringBootProject.first.Product.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {

    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    Product update(Long id,Product product);

    boolean deleteById(Long id);
}
