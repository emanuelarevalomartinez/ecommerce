package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.exceptions.DomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorMessageCode;
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

        String message =  "User with email " + email + " not found";

        return this.userRepositoryPort.findByEmail(email)
                .orElseThrow(()-> new DomainException(
                        ErrorMessageCode.USER_NOT_FOUND.getStatus(),
                        ErrorMessageCode.USER_NOT_FOUND.getType(),
                        message,
                        null
                        )
                );

    }
}
