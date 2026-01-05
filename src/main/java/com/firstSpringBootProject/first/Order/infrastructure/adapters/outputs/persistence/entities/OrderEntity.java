package com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    @Size(min = 4, max = 100)
    private String name;

    @Column(nullable = false, length = 100)
    @Size(min = 4, max = 100)
    private String code;

    @Column(nullable = true, length = 500)
    @Size(min = 4, max = 500)
    private String description;

    @Column(nullable = true, length = 500)
    @Size(min = 4, max = 500)
    private String urlImage;

    @Column(nullable = true)
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Float price;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;
}
