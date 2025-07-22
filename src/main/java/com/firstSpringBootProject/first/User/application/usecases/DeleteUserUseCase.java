package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.exceptions.UserDomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorUserMessageCode;
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

            throw new UserDomainException(
                    ErrorUserMessageCode.USER_NOT_FOUND_ID.getStatus(),
                    ErrorUserMessageCode.USER_NOT_FOUND_ID.getType(),
                    String.format(ErrorUserMessageCode.USER_NOT_FOUND_ID.getMessage(), id),
                    null
            );
        }
    }
}
