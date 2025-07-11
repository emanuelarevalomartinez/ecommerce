package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.exceptions.DomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorMessageCode;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.FindUserByUsernamePort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;

public class FindUserByUsernameUseCase implements FindUserByUsernamePort {

    private final UserRepositoryPort userRepositoryPort;

    public FindUserByUsernameUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User findByUsername(String username) {

        String message = "User with username " + username + " not found";

        return this.userRepositoryPort.findByUsername(username)
                .orElseThrow( () -> new DomainException(
                        ErrorMessageCode.USER_NOT_FOUND.getStatus(),
                        ErrorMessageCode.USER_NOT_FOUND.getType(),
                        message,
                        null
                ));
    }
}
