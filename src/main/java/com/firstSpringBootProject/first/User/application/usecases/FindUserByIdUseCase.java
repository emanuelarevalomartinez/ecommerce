package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.exceptions.DomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorMessageCode;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.FindUserByIdPort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;

public class FindUserByIdUseCase implements FindUserByIdPort {

    private final UserRepositoryPort userRepositoryPort;

    public FindUserByIdUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User findById(Long id) {

        String message = "User with id " + id + " not found";

        return  this.userRepositoryPort.findById(id)
                .orElseThrow(()-> new DomainException(
                        ErrorMessageCode.USER_NOT_FOUND.getStatus(),
                        ErrorMessageCode.USER_NOT_FOUND.getType(),
                        message,
                        null
                ));
    }
}
