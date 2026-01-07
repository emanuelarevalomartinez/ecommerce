package com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.repositories;

import com.firstSpringBootProject.first.Order.domain.models.Order;
import com.firstSpringBootProject.first.Order.domain.models.OrderProduct;
import com.firstSpringBootProject.first.Order.domain.ports.out.OrderRepositoryPort;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.entities.OrderEntity;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.mappers.OrderPersistenceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaOrderRepositoryAdapter implements OrderRepositoryPort {

    @Autowired
    private JpaOrderRepository orderPersistence;

    @Autowired
    private OrderPersistenceMapper orderMapper;

    @Override
    public Order save(Order order) {

        OrderEntity entity = orderPersistence.save(orderMapper.toOrderEntity(order));

         return orderMapper.toOrder(entity);
    }


    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }
}
