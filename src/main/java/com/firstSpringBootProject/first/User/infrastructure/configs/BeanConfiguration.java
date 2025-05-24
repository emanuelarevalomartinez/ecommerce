package com.firstSpringBootProject.first.User.infrastructure.configs;

import com.firstSpringBootProject.first.User.application.services.UserService;
import com.firstSpringBootProject.first.User.application.usecases.CreateUserUseCase;
import com.firstSpringBootProject.first.User.application.usecases.FindAllUsersUseCase;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort){
        return new UserService(
                new CreateUserUseCase(userRepositoryPort),
                new FindAllUsersUseCase(userRepositoryPort)
        );
    }

}
