package com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.controllers;

import com.firstSpringBootProject.first.User.application.usecases.*;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.in.FindUserByIdPort;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;
import com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.dto.CreateUserDto;
import com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.dto.UpdateUserDto;
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
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private FindAllUsersUseCase findAllUsersUseCase;

    @Autowired
    private FindUserByEmailUseCase findUserByEmailUseCase;

    @Autowired
    private FindUserByIdUseCase findUserByIdUseCase;

    @Autowired
    private FindUserByUsernameUseCase findUserByUsernameUseCase;

    @Autowired
    private UpdateUserByIdUseCase updateUserByIdUseCase;

    @Autowired
    private DeleteUserUseCase deleteUserUseCase;

    @Autowired
    private UserRestMapper userRestMapper;

    @PostMapping
    public User createUser(@Valid @RequestBody CreateUserDto createUserDto){
        User newUser = userRestMapper.toDomainUser(createUserDto);
        return this.createUserUseCase.save(newUser);
    }

    @GetMapping
    public List<User> findAll(){
        return this.findAllUsersUseCase.findAll();
    }

    @GetMapping("/id/{id}")
    public User findUserById(@PathVariable Long id){
        return this.findUserByIdUseCase.findById(id);
    }

    @GetMapping("/email/{email}")
    public User findUserByEmail(@PathVariable String email){
        return this.findUserByEmailUseCase.findByEmail(email);
    }

    @GetMapping("/username/{username}")
    public User findUserByUsername(@PathVariable String username){
        return this.findUserByUsernameUseCase.findByUsername(username);
    }

    @PatchMapping
    public User updateUser(@Valid @RequestBody UpdateUserDto updateUserDto){
//        User updateUser = userRestMapper.toDomainUser(updateUserDto);
//        return this.updateUserByIdUseCase(id, updateUser);
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUserById( @PathVariable Long id ){
         this.deleteUserUseCase.deleteById(id);
    }

}
