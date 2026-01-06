package com.firstSpringBootProject.first.Order.infrastructure.adapters.inputs.rest.mappers;

import com.firstSpringBootProject.first.Order.domain.models.Order;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.inputs.rest.dto.CreateOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface OrderRestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "products", target = "orderProducts"),
            @Mapping(target = "orderState", ignore = true),
            @Mapping(target = "dateCreated", ignore = true)
    })
    Order createOrderFromDtoToDomainOrder(CreateOrderDto createOrderDto);

}
