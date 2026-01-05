package com.firstSpringBootProject.first.Order.application.usecases;

import com.firstSpringBootProject.first.Order.domain.models.Order;
import com.firstSpringBootProject.first.Order.domain.ports.in.CreateOrderPort;
import com.firstSpringBootProject.first.Order.domain.ports.out.OrderRepositoryPort;

public class CreateOrderUseCase implements CreateOrderPort {

    private final OrderRepositoryPort orderRepositoryPort;

    public CreateOrderUseCase(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Order save(Order order) {
        return this.orderRepositoryPort.save(order);
    }
}
