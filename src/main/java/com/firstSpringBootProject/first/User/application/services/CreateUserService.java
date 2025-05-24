package com.firstSpringBootProject.first.User.application.services;

import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.UserRepository;

public class CreateUserService {
    private final UserRepository userRepository;

    public CreateUserService(UserRepository iUserRepository) {
        this.userRepository = iUserRepository;
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

}
