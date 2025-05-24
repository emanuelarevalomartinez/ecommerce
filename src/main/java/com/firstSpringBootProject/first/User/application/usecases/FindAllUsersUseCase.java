package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.FindAllUsersPort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;

import java.util.List;

public class FindAllUsersUseCase implements FindAllUsersPort {

    private final UserRepositoryPort userRepositoryPort;

    public FindAllUsersUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public List<User> findAll() {
        return this.userRepositoryPort.findAll();
    }
}
