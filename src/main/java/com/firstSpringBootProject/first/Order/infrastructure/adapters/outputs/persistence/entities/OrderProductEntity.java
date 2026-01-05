package com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_products")
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    @Column(nullable = false)
    private BigDecimal quantity;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Long productId;
}
