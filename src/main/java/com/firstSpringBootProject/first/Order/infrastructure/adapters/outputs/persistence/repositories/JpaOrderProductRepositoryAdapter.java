package com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.repositories;

import com.firstSpringBootProject.first.Order.domain.models.OrderProduct;
import com.firstSpringBootProject.first.Order.domain.ports.out.OrderProductRepositoryPort;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.entities.OrderProductEntity;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.mappers.OrderProductPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class JpaOrderProductRepositoryAdapter implements OrderProductRepositoryPort {

    @Autowired
    private JpaOrderProductRepository orderProductPersistence;

    @Autowired
    private OrderProductPersistenceMapper orderProductMapper;

    @Override
    public OrderProduct save(OrderProduct orderProduct) {

        OrderProductEntity entity = orderProductPersistence.save(orderProductMapper.toOrderProductEntity(orderProduct));
        return orderProductMapper.toOrderProduct(entity);
    }
}
