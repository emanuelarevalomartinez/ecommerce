package com.firstSpringBootProject.first.User.domain.ports.in;

import com.firstSpringBootProject.first.User.domain.models.User;

import java.util.Optional;

public interface FindUserByIdPort {

    User findById(Long id);
}
