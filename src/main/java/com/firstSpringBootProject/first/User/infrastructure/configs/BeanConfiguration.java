package com.firstSpringBootProject.first.User.infrastructure.configs;

import com.firstSpringBootProject.first.User.application.services.CreateUserService;
import com.firstSpringBootProject.first.User.application.services.GetAllUsersService;
import com.firstSpringBootProject.first.User.domain.ports.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateUserService userService(UserRepository userRepository){
        return new CreateUserService(userRepository);
    }

    @Bean
    public GetAllUsersService getAllUsersService(UserRepository userRepository){
        return new GetAllUsersService(userRepository);
    }

}
