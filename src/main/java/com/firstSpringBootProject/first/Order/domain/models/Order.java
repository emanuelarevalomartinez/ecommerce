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

    public Order() {
        orderProducts = new ArrayList<>();
    }

//    public BigDecimal getTotalOrderPrice(){
//        return this.orderProducts.stream().map( orderProduct -> {
//
//            return  orderProduct.getTotalItems();
//        } ).reduce(BigDecimal.ZERO,BigDecimal::add);
//    }
    
public BigDecimal getTotalOrderPrice() {
    BigDecimal total = BigDecimal.ZERO;

    for (OrderProduct orderProduct : this.orderProducts) {
        total = total.add(orderProduct.getTotalItems());
    }
    return total;
}

}
