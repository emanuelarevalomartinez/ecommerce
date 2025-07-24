package com.firstSpringBootProject.first.Product.infrastructure.adapters.outputs.persistence.repositories;

import com.firstSpringBootProject.first.Product.infrastructure.adapters.outputs.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByName(String name);
}
