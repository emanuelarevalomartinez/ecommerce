package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.CreateUserPort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;

public class CreateUserUseCase implements CreateUserPort {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User save(User user) {
        return this.userRepositoryPort.save(user);
    }



 /*   private final UserRepositoryPort userRepository;

    public CreateUserUseCase(UserRepositoryPort iUserRepository) {
        this.userRepository = iUserRepository;
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }*/

}
