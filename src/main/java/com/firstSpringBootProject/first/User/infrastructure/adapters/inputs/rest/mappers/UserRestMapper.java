package com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.mappers;

import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.dto.CreateUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserRestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "cellphone", target = "cellphone"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "userType", target = "userType"),
            @Mapping(target = "dateCreated", ignore = true),
            @Mapping(target = "dateUpdated", ignore = true)
    })
    User toDomainUser(CreateUserDto createUserDto);

    // Si necesitas devolver un DTO de respuesta, lo definirías aquí:
    // @Mapping(source = "id", target = "id")
    // UserResponseDto toResponseDto(User user);



}