package com.firstSpringBootProject.first.User.application.services;

import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.UserRepository;

import java.util.List;

public class GetAllUsersService {

    private final UserRepository userRepository;


    public GetAllUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }
}
