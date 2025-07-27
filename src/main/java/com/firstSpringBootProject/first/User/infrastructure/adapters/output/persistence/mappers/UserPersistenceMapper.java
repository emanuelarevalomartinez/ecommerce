package com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.mappers;


import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.entities.UserEntity;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "username", target = "username"),
                    @Mapping(source = "lastName", target = "lastName"),
                    @Mapping(source = "email", target = "email"),
                    @Mapping(source = "address", target = "address"),
                    @Mapping(source = "cellphone", target = "cellphone"),
                    @Mapping(source = "password", target = "password"),
                    @Mapping(source = "userType", target = "userType"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "dateUpdated", target = "dateUpdated"),
                    @Mapping(source = "products", target = "products")
            }
    )

    User toUser(UserEntity userEntity);


    List<User> toUsers(List<UserEntity> userEntities);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    UserEntity toUserEntity(User user);

}
