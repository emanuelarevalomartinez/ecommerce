package com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.mappers;

import com.firstSpringBootProject.first.Order.domain.models.OrderProduct;
import com.firstSpringBootProject.first.Order.infrastructure.adapters.outputs.persistence.entities.OrderProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderProductPersistenceMapper {


    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "quantity", target = "quantity"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "productId", target = "productId"),
            }
    )
    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);


    List<OrderProduct> toOrdersProducts(List<OrderProductEntity> orderProductEntities);

    @InheritInverseConfiguration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);

}
