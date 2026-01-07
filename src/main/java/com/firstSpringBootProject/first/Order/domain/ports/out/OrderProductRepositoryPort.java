package com.firstSpringBootProject.first.Order.domain.ports.out;
import com.firstSpringBootProject.first.Order.domain.models.OrderProduct;

public interface OrderProductRepositoryPort {
    OrderProduct save(OrderProduct orderProduct);
}
