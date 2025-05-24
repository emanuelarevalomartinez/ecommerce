package com.firstSpringBootProject.first.User.infrastructure.adapters.repositories;

import com.firstSpringBootProject.first.User.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersistence extends JpaRepository<UserEntity, Long> {

}
