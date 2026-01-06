package com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.mappers;

import com.firstSpringBootProject.first.Order.domain.models.Order;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.entities.OrderEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "orderProducts", target = "orderProducts"),
                    @Mapping(source = "orderState", target = "orderState"),
                    @Mapping(source = "userId", target = "userId"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
            }
    )
    Order toOrder(OrderEntity orderEntity);


    List<Order> toOrders(List<OrderEntity> orderEntities);

    @InheritInverseConfiguration
    OrderEntity toOrderEntity(Order order);

   /* @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateOrderFromDtoToDomainOrder(UpdateUserDto updateUserDto);*/

}
