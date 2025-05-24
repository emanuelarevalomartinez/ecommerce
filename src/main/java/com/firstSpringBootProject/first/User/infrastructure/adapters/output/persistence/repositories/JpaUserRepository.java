package com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.repositories;

import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

}
