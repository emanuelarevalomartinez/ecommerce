package com.firstSpringBootProject.first.User.domain.ports;

import com.firstSpringBootProject.first.User.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    User update(Long id,User user);

    void deleteById(Long id);
}
