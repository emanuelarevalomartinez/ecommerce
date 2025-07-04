package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.UpdateUserByIdPort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;

public class UpdateUserByIdUseCase implements UpdateUserByIdPort {

    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserByIdUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User update(Long id, User user) {
        return this.userRepositoryPort.update(id, user);
    }
}
