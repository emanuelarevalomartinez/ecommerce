package com.firstSpringBootProject.first.Order.domain.models;

import java.math.BigDecimal;

public class OrderProduct {

    private Long id;
    private BigDecimal quantity;
    private BigDecimal price;
    private Long productId;

    public OrderProduct() {
    }

    public OrderProduct(Long id, BigDecimal quantity, BigDecimal price, Long productId) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }

    public OrderProduct(BigDecimal quantity, BigDecimal price, Long productId) {
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getTotalItems(){
        return this.price.multiply(quantity);
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", productId=" + productId +
                '}';
    }
}
