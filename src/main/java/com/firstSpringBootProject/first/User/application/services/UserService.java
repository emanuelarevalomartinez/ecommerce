package com.firstSpringBootProject.first.User.application.services;

import com.firstSpringBootProject.first.User.application.usecases.CreateUserUseCase;
import com.firstSpringBootProject.first.User.application.usecases.FindAllUsersUseCase;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.CreateUserPort;
import com.firstSpringBootProject.first.User.domain.ports.in.FindAllUsersPort;

import java.util.List;

public class UserService implements CreateUserPort, FindAllUsersPort {

    private final CreateUserUseCase createUserService;
    private final FindAllUsersUseCase getAllUsersService;


    public UserService(CreateUserUseCase createUserService, FindAllUsersUseCase getAllUsersService) {
        this.createUserService = createUserService;
        this.getAllUsersService = getAllUsersService;
    }


    @Override
    public User save(User user) {
        return this.createUserService.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.getAllUsersService.findAll();
    }
}
