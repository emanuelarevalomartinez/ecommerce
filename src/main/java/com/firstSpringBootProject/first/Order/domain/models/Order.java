package com.firstSpringBootProject.first.Order.domain.models;

import com.firstSpringBootProject.first.Order.domain.enums.OrderState;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private LocalDateTime dateCreated;
    private List<OrderProduct> orderProducts;
    private OrderState orderState;
    private Long userId;

    public Order(Long id, LocalDateTime dateCreated, List<OrderProduct> orderProducts, OrderState orderState, Long userId) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.orderProducts = orderProducts;
        this.orderState = orderState;
        this.userId = userId;
    }

    public Order() {
        orderProducts = new ArrayList<>();
    }
    
public BigDecimal getTotalOrderPrice() {
    BigDecimal total = BigDecimal.ZERO;

    for (OrderProduct orderProduct : this.orderProducts) {
        total = total.add(orderProduct.getTotalItems());
    }
    return total;
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

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
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
}
