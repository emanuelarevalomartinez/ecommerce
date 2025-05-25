package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.exceptions.UserNotFoundException;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.FindUserByIdPort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

public class FindUserByIdUseCase implements FindUserByIdPort {

    private final UserRepositoryPort userRepositoryPort;

    public FindUserByIdUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User findById(Long id) {
        return  this.userRepositoryPort.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
    }
}
