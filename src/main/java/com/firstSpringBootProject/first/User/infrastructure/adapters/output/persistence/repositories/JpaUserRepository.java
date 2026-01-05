package com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.repositories;

import com.firstSpringBootProject.first.User.infrastructure.adapters.output.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByUsername(String username);

//    @EntityGraph(attributePaths = {"products"})
//    @Override
//    List<UserEntity> findAll();

    @Query("SELECT DISTINCT u FROM UserEntity u LEFT JOIN FETCH u.products")
    List<UserEntity> findAllWithProducts();
}
