package com.firstSpringBootProject.first.User.domain.ports.out;

import com.firstSpringBootProject.first.User.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    User update(Long id,User user);

    void deleteById(Long id);
}
