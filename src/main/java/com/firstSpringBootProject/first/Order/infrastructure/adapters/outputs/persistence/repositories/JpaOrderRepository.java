package com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.repositories;

import com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {
}
