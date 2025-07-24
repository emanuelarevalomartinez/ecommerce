package com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstSpringBootProject.first.User.application.usecases.*;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.dto.CreateUserDto;
import com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.dto.UpdateUserDto;
import com.firstSpringBootProject.first.User.infrastructure.adapters.inputs.rest.mappers.UserRestMapper;
import com.firstSpringBootProject.first.shared.ApiResponse.ApiResponse;
import com.firstSpringBootProject.first.shared.ApiResponse.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
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

    // verificar que todos los metodos funcionen bien y sigan el estandar
    // usar el maper para a partir del nombre, first name y full name crear el fullName y asi darle uso al maper
    // quitar el campo username y asignarlo de forma interna



    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser(@Valid @RequestBody CreateUserDto createUserDto) {

        User newUser = userRestMapper.createUserFromDtoToDomainUser(createUserDto);

        User savedUser = this.createUserUseCase.save(newUser);

        return ResponseHandler.generateResponse(
                HttpStatus.CREATED,
                null,
                "Successfully created user",
                savedUser
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> findAll(){

        List<User> allUsers = this.findAllUsersUseCase.findAll();

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                null,
                allUsers
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse<User>> findUserById(@PathVariable Long id){

        User findUser = this.findUserByIdUseCase.findById(id);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                null,
                findUser
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<User>> findUserByEmail(@PathVariable String email){

        User findUser = this.findUserByEmailUseCase.findByEmail(email);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                null,
                findUser
        );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<ApiResponse<User>> findUserByUsername(@PathVariable String username){

        User findUser = this.findUserByUsernameUseCase.findByUsername(username);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                null,
                findUser
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserDto updateUserDto){

        User updateUser = userRestMapper.updateUserFromDtoToDomainUser(updateUserDto);

        User savedUpdateUser = this.updateUserByIdUseCase.update(id, updateUser);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                "Successfully update user",
                savedUpdateUser
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteUserById(@PathVariable Long id ){

         this.deleteUserUseCase.deleteById(id);

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                null,
                "User successfully deleted",
                null
        );
    }

}
