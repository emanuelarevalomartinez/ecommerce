package com.firstSpringBootProject.first.User.domain.ports.in;
import com.firstSpringBootProject.first.User.domain.models.User;

public interface UpdateUserByIdPort {

    User update(Long id, User user);
}
