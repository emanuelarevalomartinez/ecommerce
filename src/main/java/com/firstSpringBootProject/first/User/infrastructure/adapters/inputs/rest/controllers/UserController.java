package com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.controllers;

import com.firstSpringBootProject.first.User.application.usecases.CreateUserUseCase;
import com.firstSpringBootProject.first.User.application.usecases.FindAllUsersUseCase;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepositoryPort userRepositoryPort;

    @PostMapping
    public User createUser(@RequestBody User user){
        return this.userRepositoryPort.save(user);
    }

    @GetMapping
    public List<User> findAll(){
        return this.userRepositoryPort.findAll();
    }



}
