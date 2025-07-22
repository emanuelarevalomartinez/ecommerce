package com.firstSpringBootProject.first.Category.infrastructure.adapters.inputs.rest.mappers;


import com.firstSpringBootProject.first.Category.domain.models.Category;
import com.firstSpringBootProject.first.Category.infrastructure.adapters.inputs.rest.dto.CreateCategoryDto;
import com.firstSpringBootProject.first.Category.infrastructure.adapters.inputs.rest.dto.UpdateCategoryDto;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.dto.UpdateUserDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryRestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "name", target = "name"),
            @Mapping(target = "dateCreated", ignore = true),
            @Mapping(target = "dateUpdated", ignore = true)
    })


    Category createCategoryFromDtoToDomainUser(CreateCategoryDto createCategoryDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category updateCategoryFromDtoToDomainCategory(UpdateCategoryDto updateCategoryDto);

}
