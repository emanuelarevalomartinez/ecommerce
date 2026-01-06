package com.firstSpringBootProject.first.Order.infrastructure.adapters.inputs.rest.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class CreateOrderProductDto {

    @NotNull(message = "Product Id is required")
    @Positive(message = "Product Id must be greater than zero")
    private Long productId;

    @NotNull(message = "Quantity is required")
    @DecimalMin(value = "0.01", inclusive = true, message = "Quantity must be greater than 0")
    private BigDecimal quantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", inclusive = true, message = "Price must be greater than 0")
    private BigDecimal price;

    // ===== Getters & Setters =====

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

}
