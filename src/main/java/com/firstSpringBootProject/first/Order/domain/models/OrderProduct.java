package com.firstSpringBootProject.first.Order.domain.models;

import java.math.BigDecimal;

public class OrderProduct {

    private Long id;
    private BigDecimal quantity;
    private BigDecimal price;
    private Long productId;


    public BigDecimal getTotalItems(){
        return this.price.multiply(quantity);
    }
}
