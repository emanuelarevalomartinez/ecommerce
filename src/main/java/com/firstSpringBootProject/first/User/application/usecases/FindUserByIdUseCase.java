package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.exceptions.UserDomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorUserMessageCode;
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

        return  this.userRepositoryPort.findById(id)
                .orElseThrow(()-> new UserDomainException(
                        ErrorUserMessageCode.USER_NOT_FOUND_ID.getStatus(),
                        ErrorUserMessageCode.USER_NOT_FOUND_ID.getType(),
                        String.format(ErrorUserMessageCode.USER_NOT_FOUND_ID.getMessage() + id),
                        null
                ));
    }
}
