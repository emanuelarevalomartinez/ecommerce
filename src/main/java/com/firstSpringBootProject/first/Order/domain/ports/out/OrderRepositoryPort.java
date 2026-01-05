package com.firstSpringBootProject.first.Order.domain.ports.out;

import com.firstSpringBootProject.first.Order.domain.models.Order;
import com.firstSpringBootProject.first.Product.domain.models.Product;

import java.util.Optional;

public interface OrderRepositoryPort {
    Order save(Order order);
    Optional<Order> findById(Long id);
}
