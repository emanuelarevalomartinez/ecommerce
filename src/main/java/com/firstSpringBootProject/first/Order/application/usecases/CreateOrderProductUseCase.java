package com.firstSpringBootProject.first.Order.application.usecases;

import com.firstSpringBootProject.first.Order.domain.models.OrderProduct;
import com.firstSpringBootProject.first.Order.domain.ports.in.CreateOrderProductPort;
import com.firstSpringBootProject.first.Order.domain.ports.out.OrderProductRepositoryPort;
import com.firstSpringBootProject.first.Product.domain.ports.out.ProductRepositoryPort;

public class CreateOrderProductUseCase implements CreateOrderProductPort {

    private final OrderProductRepositoryPort orderProductRepositoryPort;

    public CreateOrderProductUseCase(OrderProductRepositoryPort orderProductRepositoryPort) {
        this.orderProductRepositoryPort = orderProductRepositoryPort;
    }

    @Override
    public OrderProduct save(OrderProduct orderProduct) {
        return this.orderProductRepositoryPort.save(orderProduct);
    }
}
