package com.firstSpringBootProject.first.Product.domain.ports.in;

import com.firstSpringBootProject.first.Product.domain.models.Product;

public interface FindProductByIdPort {
    Product findById(Long id);
}
