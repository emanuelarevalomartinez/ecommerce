package com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.repositories;

import com.firstSpringBootProject.first.User.domain.exceptions.UserDomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorUserMessageCode;
import com.firstSpringBootProject.first.User.domain.models.User;
import com.firstSpringBootProject.first.User.domain.ports.out.UserRepositoryPort;
import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.entities.UserEntity;
import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.mappers.UserPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    @Autowired
    private JpaUserRepository userPersistence;

    @Autowired
    private UserPersistenceMapper userMapper;


    @Override
    public User save(User user) {
        if (this.findByEmail(user.getEmail()).isPresent()) {

            throw new UserDomainException(
                    ErrorUserMessageCode.EMAIL_CONFLICT.getStatus(),
                    ErrorUserMessageCode.EMAIL_CONFLICT.getType(),
                    String.format(ErrorUserMessageCode.EMAIL_CONFLICT.getMessage() + user.getEmail()),
                    null
            );

        }

        if (this.findByUsername(user.getUsername()).isPresent()) {

            throw new UserDomainException(
                    ErrorUserMessageCode.USERNAME_CONFLICT.getStatus(),
                    ErrorUserMessageCode.USERNAME_CONFLICT.getType(),
                    String.format(ErrorUserMessageCode.USERNAME_CONFLICT.getMessage() + user.getUsername()),
                    null
            );
        }

        UserEntity entity = userPersistence.save(userMapper.toUserEntity(user));
        return userMapper.toUser(entity);
    }


    @Override
    @Transactional
    public List<User> findAll() {
        return userMapper.toUsers(userPersistence.findAll());
    }

    @Override
    public Optional<User> findById(Long id) {
        return userPersistence.findById(id)
                .map(userMapper::toUser);
    }

    public UserEntity findEntityById(Long id) {
        return userPersistence.findById(id)
                .orElseThrow( () -> new UserDomainException(
                ErrorUserMessageCode.USER_NOT_FOUND_ID.getStatus(),
                ErrorUserMessageCode.USER_NOT_FOUND_ID.getType(),
                String.format(ErrorUserMessageCode.USER_NOT_FOUND_ID.getMessage() + id),
                null
        ) );
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

                .orElseThrow(() -> new UserDomainException(
                                        ErrorUserMessageCode.USER_NOT_FOUND_ID.getStatus(),
                                        ErrorUserMessageCode.USER_NOT_FOUND_ID.getType(),
                                        String.format(ErrorUserMessageCode.USER_NOT_FOUND_ID.getMessage() + id),
                                        null
                                ));

        if(user.getEmail() != null){
            existingEntity.setEmail(user.getEmail());
        }
        if(user.getUsername() != null){
            existingEntity.setUsername(user.getUsername());
        }
        if(user.getFirstName() != null){
            existingEntity.setFirstName(user.getFirstName());
        }
        if(user.getLastName() != null){
            existingEntity.setLastName(user.getLastName());
        }
        if(user.getAddress() != null){
            existingEntity.setAddress(user.getAddress());
        }
        if(user.getCellphone() != null){
            existingEntity.setCellphone(user.getCellphone());
        }
        if(user.getPassword() != null){
            existingEntity.setPassword(user.getPassword());
        }
        if(user.getUserType() != null){
            existingEntity.setUserType(user.getUserType());
        }

         UserEntity updatedEntity = userPersistence.save(existingEntity);
        return userMapper.toUser(updatedEntity);
    }

    @Override
    public boolean deleteById(Long id) {

        Optional<User> existingUser = this.findById(id);

        if (existingUser.isPresent()) {
            userPersistence.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
