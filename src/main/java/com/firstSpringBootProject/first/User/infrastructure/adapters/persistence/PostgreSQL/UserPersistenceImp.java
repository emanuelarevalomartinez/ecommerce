package com.firstSpringBootProject.first.User.infrastructure.adapters.persistence.PostgreSQL;

import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.UserRepository;
import com.firstSpringBootProject.first.User.infrastructure.adapters.repositories.UserPersistence;
import com.firstSpringBootProject.first.User.infrastructure.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserPersistenceImp implements UserRepository {

    @Autowired
    private UserPersistence userPersistence;

    @Autowired
    private UserMapper userMapper;


    @Override
    public User save(User user) {
        return userMapper.toUser(userPersistence.save(userMapper.toUserEntity(user)));
    }

    @Override
    public List<User> findAll() {
        return userMapper.toUsers(userPersistence.findAll());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
