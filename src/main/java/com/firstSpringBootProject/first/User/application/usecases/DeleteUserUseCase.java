package com.firstSpringBootProject.first.User.application.usecases;

import com.firstSpringBootProject.first.User.domain.ports.in.DeleteUserPort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;

public class DeleteUserUseCase  implements DeleteUserPort {

    private final UserRepositoryPort userRepositoryPort;


    public DeleteUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public void deleteById(Long id) {
       this.userRepositoryPort.deleteById(id);
    }
}
