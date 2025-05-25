package com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.controllers;

import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.FindUserByIdPort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;
import com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.dto.CreateUserDto;
import com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.mappers.UserRestMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepositoryPort userRepositoryPort;

    @Autowired
    private FindUserByIdPort findUserByIdPort;

    @Autowired
    private UserRestMapper userRestMapper;

    @PostMapping
    public User createUser(@Valid @RequestBody CreateUserDto createUserDto){
        User newUser = userRestMapper.toDomainUser(createUserDto);
        return this.userRepositoryPort.save(newUser);
    }

    @GetMapping
    public List<User> findAll(){
        return this.userRepositoryPort.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
        return this.findUserByIdPort.findById(id);
    }

}
