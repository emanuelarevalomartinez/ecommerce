package com.firstSpringBootProject.first.Product.infrastructure.adapters.inputs.rest.mappers;

import com.firstSpringBootProject.first.Product.domain.models.Product;
import com.firstSpringBootProject.first.Product.infrastructure.adapters.inputs.rest.dto.CreateProductDto;
import com.firstSpringBootProject.first.Product.infrastructure.adapters.inputs.rest.dto.UpdateProductDto;
import org.mapstruct.*;


@Mapper( componentModel = "spring")
public interface ProductRestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "urlImage", target = "urlImage"),
            @Mapping(source = "price", target = "price"),
            @Mapping(target = "dateCreated", ignore = true),
            @Mapping(target = "dateUpdated", ignore = true),
            @Mapping(source = "userId", target = "userId"),
            @Mapping( source = "categoryId", target = "categoryId")
    })
    Product createProductFromDtoToDomainProduct(CreateProductDto createProductDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product updateProductFromDtoToDomainProduct(UpdateProductDto updateProductDto);


}
