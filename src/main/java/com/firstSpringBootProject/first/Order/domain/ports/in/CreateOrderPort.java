package com.firstSpringBootProject.first.Order.domain.ports.in;

import com.firstSpringBootProject.first.Order.domain.models.Order;

public interface CreateOrderPort {
    Order save(Order order);
}
