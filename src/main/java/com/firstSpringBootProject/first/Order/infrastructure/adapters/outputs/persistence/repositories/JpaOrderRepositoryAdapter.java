package com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.repositories;

import com.firstSpringBootProject.first.Order.domain.models.Order;
import com.firstSpringBootProject.first.Order.domain.models.OrderProduct;
import com.firstSpringBootProject.first.Order.domain.ports.out.OrderRepositoryPort;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.entities.OrderEntity;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.mappers.OrderPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class JpaOrderRepositoryAdapter implements OrderRepositoryPort {

    @Autowired
    private JpaOrderRepository orderPersistence;

    @Autowired
    private OrderPersistenceMapper orderMapper;

    @Override
    public Order save(Order order) {

        OrderProduct product1 = new OrderProduct(
                BigDecimal.valueOf(2),   // quantity
                BigDecimal.valueOf(12.50), // price
                101L                      // productId
        );

        OrderProduct product2 = new OrderProduct(
                BigDecimal.valueOf(1),    // quantity
                BigDecimal.valueOf(24.99), // price
                102L                       // productId
        );

        // 2️⃣ Añadirlos a la lista
        List<OrderProduct> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        // 3️⃣ Crear la orden y asignar productos
        Order o = new Order();
        order.setId(1L);
        order.setUserId(500L);
        order.setDateCreated(LocalDateTime.now());
        order.setOrderState(com.firstSpringBootProject.first.Order.domain.enums.OrderState.CONFIRM);
        order.setOrderProducts(products);

        return o;

      //  OrderEntity entity = orderPersistence.save(orderMapper.toOrderEntity(order));

       //  return orderMapper.toOrder(entity);
    }


    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }
}
