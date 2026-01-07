package com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.repositories;

import com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.entities.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderProductRepository extends JpaRepository<OrderProductEntity, Long> {
}
