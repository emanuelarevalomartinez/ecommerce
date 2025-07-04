package com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.repositories;

import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;
import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.entities.UserEntity;
import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.mappers.UserPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    @Autowired
    private JpaUserRepository userPersistence;

    @Autowired
    private UserPersistenceMapper userMapper;


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
        return userPersistence.findById(id)
                .map(userMapper::toUser);
//        return Optional.ofNullable(userMapper.toUser(userPersistence.findById(id).get()));
    }

    @Override
    public Optional<User> findByEmail(String email) {
    return userPersistence.findByEmail(email)
            .map(userMapper::toUser);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userPersistence.findByUsername(username)
                .map(userMapper::toUser);
    }

    @Override
    public User update(Long id, User user) {
        UserEntity existingEntity = userPersistence.findById(id)
                .orElseThrow(() -> new RuntimeException("Updating User with ID " + id + " was not found"));

        existingEntity.setEmail(user.getEmail());
        existingEntity.setUsername(user.getUsername());
        existingEntity.setFirstName(user.getFirstName());
        existingEntity.setLastName(user.getLastName());
        existingEntity.setAddress(user.getAddress());
        existingEntity.setCellphone(user.getCellphone());
        existingEntity.setPassword(user.getPassword());
        existingEntity.setUserType(user.getUserType());

        UserEntity updatedEntity = userPersistence.save(existingEntity);
        return userMapper.toUser(updatedEntity);
       /* return null;*/
    }

    @Override
    public void deleteById(Long id) {
      userPersistence.deleteById(id);
    }
}
