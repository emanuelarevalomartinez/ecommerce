package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.exceptions.UserDomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorUserMessageCode;
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

        return this.userRepositoryPort.findByUsername(username)
                .orElseThrow( () -> new UserDomainException(
                        ErrorUserMessageCode.USER_NOT_FOUND_USERNAME.getStatus(),
                        ErrorUserMessageCode.USER_NOT_FOUND_USERNAME.getType(),
                        String.format(ErrorUserMessageCode.USER_NOT_FOUND_USERNAME.getMessage(), username),
                        null
                ));
    }
}
