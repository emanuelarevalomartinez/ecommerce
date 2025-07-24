package com.firstSpringBootProject.first.Product.domain.ports.in;

import com.firstSpringBootProject.first.Product.domain.models.Product;

public interface CreateProductPort {
    Product save(Product product);
}
