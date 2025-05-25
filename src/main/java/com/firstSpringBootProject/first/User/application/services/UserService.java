package com.firstSpringBootProject.first.User.application.services;

import com.firstSpringBootProject.first.User.application.usecases.CreateUserUseCase;
import com.firstSpringBootProject.first.User.application.usecases.FindAllUsersUseCase;
import com.firstSpringBootProject.first.User.application.usecases.FindUserByIdUseCase;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.CreateUserPort;
import com.firstSpringBootProject.first.User.domain.ports.in.FindAllUsersPort;
import com.firstSpringBootProject.first.User.domain.ports.in.FindUserByIdPort;

import java.util.List;

public class UserService implements CreateUserPort, FindAllUsersPort, FindUserByIdPort {

    private final CreateUserUseCase createUserService;
    private final FindAllUsersUseCase getAllUsersService;
    private final FindUserByIdUseCase findUserByIdUseCase;

    public UserService(CreateUserUseCase createUserService, FindAllUsersUseCase getAllUsersService, FindUserByIdUseCase findUserByIdUseCase) {
        this.createUserService = createUserService;
        this.getAllUsersService = getAllUsersService;
        this.findUserByIdUseCase = findUserByIdUseCase;
    }


    @Override
    public User save(User user) {
        return this.createUserService.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.getAllUsersService.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.findUserByIdUseCase.findById(id);
    }
}
