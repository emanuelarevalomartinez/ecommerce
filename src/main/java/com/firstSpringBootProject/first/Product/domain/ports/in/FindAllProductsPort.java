package com.firstSpringBootProject.first.Product.domain.ports.in;

import com.firstSpringBootProject.first.Product.domain.models.Product;

import java.util.List;

public interface FindAllProductsPort {
    List<Product> findAll();
}
