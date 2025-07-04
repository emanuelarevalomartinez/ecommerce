package com.firstSpringBootProject.first.User.infrastructure.configs;
import com.firstSpringBootProject.first.User.application.usecases.*;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepositoryPort userRepositoryPort) {
        return new CreateUserUseCase(userRepositoryPort);
    }

    @Bean
    public FindAllUsersUseCase findAllUsersUseCase(UserRepositoryPort userRepositoryPort) {
        return new FindAllUsersUseCase(userRepositoryPort);
    }

    @Bean
    public FindUserByEmailUseCase findUserByEmailUseCase(UserRepositoryPort userRepositoryPort) {
        return new FindUserByEmailUseCase(userRepositoryPort);
    }

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(UserRepositoryPort userRepositoryPort) {
        return new FindUserByIdUseCase(userRepositoryPort);
    }

    @Bean
    public FindUserByUsernameUseCase findUserByUsernameUseCase(UserRepositoryPort userRepositoryPort) {
        return new FindUserByUsernameUseCase(userRepositoryPort);
    }

    @Bean
    public UpdateUserByIdUseCase updateUserByIdUseCase(UserRepositoryPort userRepositoryPort) {
        return new UpdateUserByIdUseCase(userRepositoryPort);
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(UserRepositoryPort userRepositoryPort) {
        return new DeleteUserUseCase(userRepositoryPort);
    }

}
