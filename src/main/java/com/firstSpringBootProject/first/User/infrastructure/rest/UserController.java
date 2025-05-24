package com.firstSpringBootProject.first.User.infrastructure.rest;

import com.firstSpringBootProject.first.User.application.services.CreateUserService;
import com.firstSpringBootProject.first.User.application.services.GetAllUsersService;
import com.firstSpringBootProject.first.User.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private CreateUserService createUserService;

    @Autowired
    private GetAllUsersService getAllUsersService;

    @GetMapping
    public List<User> findAll(){
        return this.getAllUsersService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
      return this.createUserService.save(user);
    }



}
