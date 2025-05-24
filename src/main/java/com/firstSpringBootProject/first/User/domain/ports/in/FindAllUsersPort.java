package com.firstSpringBootProject.first.User.domain.ports.in;

import com.firstSpringBootProject.first.User.domain.models.User;

import java.util.List;

public interface FindAllUsersPort {

    List<User> findAll();
}
