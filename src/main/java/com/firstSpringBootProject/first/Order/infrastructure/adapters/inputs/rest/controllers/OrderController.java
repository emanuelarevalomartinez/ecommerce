package com.firstSpringBootProject.first.Order.infrastructure.adapters.inputs.rest.controllers;

import com.firstSpringBootProject.first.Order.application.usecases.CreateOrderUseCase;
import com.firstSpringBootProject.first.Order.domain.models.Order;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.inputs.rest.dto.CreateOrderDto;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.inputs.rest.mappers.OrderRestMapper;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.dto.CreateUserDto;
import com.firstSpringBootProject.first.shared.ApiResponse.ApiResponse;
import com.firstSpringBootProject.first.shared.ApiResponse.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private CreateOrderUseCase createOrderUseCase;

    @Autowired
    private OrderRestMapper orderRestMapper;


    @PostMapping
    public ResponseEntity<ApiResponse<Order>> createUser(@Valid @RequestBody CreateOrderDto createOrderDto) {

        Order newOrder = orderRestMapper.createOrderFromDtoToDomainOrder(createOrderDto);

        Order savedOrder = this.createOrderUseCase.save(newOrder);

        return ResponseHandler.generateResponse(
                HttpStatus.CREATED,
                null,
                "Successfully created order",
                savedOrder
        );
    }


}
