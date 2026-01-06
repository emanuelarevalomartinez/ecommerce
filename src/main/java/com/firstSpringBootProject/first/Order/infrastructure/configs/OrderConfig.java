package com.firstSpringBootProject.first.Order.infrastructure.configs;

import com.firstSpringBootProject.first.Order.application.usecases.CreateOrderUseCase;
import com.firstSpringBootProject.first.Order.domain.ports.out.OrderRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderRepositoryPort orderRepositoryPort) {
        return new CreateOrderUseCase(orderRepositoryPort);
    }

}
