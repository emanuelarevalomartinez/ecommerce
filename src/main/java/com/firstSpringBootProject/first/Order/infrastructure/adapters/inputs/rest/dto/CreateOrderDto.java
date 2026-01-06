package com.firstSpringBootProject.first.Order.infrastructure.adapters.inputs.rest.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class CreateOrderDto {

    @NotNull(message = "User Id is required")
    @Positive(message = "User Id must be greater than zero")
    private Long userId;

    @NotEmpty(message = "Order must contain at least one product")
    @Valid
    private List<CreateOrderProductDto> products;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CreateOrderProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<CreateOrderProductDto> products) {
        this.products = products;
    }

}
