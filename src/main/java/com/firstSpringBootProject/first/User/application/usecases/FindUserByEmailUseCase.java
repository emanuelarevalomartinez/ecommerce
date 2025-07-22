package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.exceptions.UserDomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorUserMessageCode;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.FindUserByEmailPort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;

public class FindUserByEmailUseCase implements FindUserByEmailPort {

    private final UserRepositoryPort userRepositoryPort;

    public FindUserByEmailUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User findByEmail(String email) {

        return this.userRepositoryPort.findByEmail(email)
                .orElseThrow(()-> new UserDomainException(
                        ErrorUserMessageCode.USER_NOT_FOUND_EMAIL.getStatus(),
                        ErrorUserMessageCode.USER_NOT_FOUND_EMAIL.getType(),
                        String.format(ErrorUserMessageCode.USER_NOT_FOUND_EMAIL.getMessage(), email),
                        null
                        )
                );

    }
}
