package com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.repositories;

import com.firstSpringBootProject.first.User.domain.exceptions.DomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.ErrorMessageCode;
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
        if (this.findByEmail(user.getEmail()).isPresent()) {

            String message = " User with email " + user.getEmail() + " already exist";

            throw new DomainException(
                    ErrorMessageCode.EMAIL_CONFLICT.getStatus(),
                    ErrorMessageCode.PERSISTENCE_ERROR.getType(),
                    message
                    , null
            );

        }

        if (this.findByUsername(user.getUsername()).isPresent()) {

            String message = " User with username " + user.getUsername() + " already exist";

            throw new DomainException(
                    ErrorMessageCode.USERNAME_CONFLICT.getStatus(),
                    ErrorMessageCode.USERNAME_CONFLICT.getType(),
                    message
                    , null
            );
        }

        UserEntity entity = userPersistence.save(userMapper.toUserEntity(user));
        return userMapper.toUser(entity);
    }


    @Override
    public List<User> findAll() {
        return userMapper.toUsers(userPersistence.findAll());
    }

    @Override
    public Optional<User> findById(Long id) {
        return userPersistence.findById(id)
                .map(userMapper::toUser);
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

        String message = "Updating User with ID " + id + " was not found";

        UserEntity existingEntity = userPersistence.findById(id)

                .orElseThrow(() -> new DomainException(
                                        ErrorMessageCode.USER_NOT_FOUND.getStatus(),
                                        ErrorMessageCode.USER_NOT_FOUND.getType(),
                                        message,
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
     // userPersistence.deleteById(id);
     // return false;
        Optional<User> existingUser = this.findById(id);

        if (existingUser.isPresent()) {
            userPersistence.deleteById(id); // Llama al método void de Spring Data JPA
            return true; // El usuario existía y se intentó eliminar
        } else {
            return false; // El usuario no fue encontrado
        }
    }
}
