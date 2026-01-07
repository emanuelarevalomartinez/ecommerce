package com.firstSpringBootProject.first.Order.domain.ports.in;

import com.firstSpringBootProject.first.Order.domain.models.OrderProduct;

public interface CreateOrderProductPort {
    OrderProduct save(OrderProduct orderProduct);
}
