package com.firstSpringBootProject.first.Product.domain.ports.in;

import com.firstSpringBootProject.first.Category.domain.models.Category;
import com.firstSpringBootProject.first.Product.domain.models.Product;

public interface UpdateProductPort {
    Product update(Long id, Product product);
}
