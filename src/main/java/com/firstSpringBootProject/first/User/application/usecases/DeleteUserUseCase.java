package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.exceptions.DomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorMessageCode;
import com.firstSpringBootProject.first.User.domain.ports.in.DeleteUserPort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;

public class DeleteUserUseCase  implements DeleteUserPort {

    private final UserRepositoryPort userRepositoryPort;


    public DeleteUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public void deleteById(Long id) {

        boolean deleted = userRepositoryPort.deleteById(id);
        if (!deleted) {
            String message =  "User with id " + id + " not found to delete";

            throw new DomainException(
                    ErrorMessageCode.USER_NOT_FOUND.getStatus(),
                    ErrorMessageCode.USER_NOT_FOUND.getType(),
                    message,
                    null
            );
        }
    }
}
