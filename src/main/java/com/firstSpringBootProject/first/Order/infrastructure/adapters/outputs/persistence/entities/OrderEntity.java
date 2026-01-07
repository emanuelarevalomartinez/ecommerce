package com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.entities;

import com.firstSpringBootProject.first.Order.domain.enums.OrderState;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderState orderState;

    @Column(nullable = false)
    private Long userId;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<OrderProductEntity> orderProducts = new ArrayList<>();

    public OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderProductEntity> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductEntity> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", orderState=" + orderState +
                ", userId=" + userId +
                ", orderProducts=" + orderProducts +
                '}';
    }
}
