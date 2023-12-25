package com.postman.app.service;

import com.postman.app.model.User;

import java.util.List;

public interface UserService {
    User getUserById(long userId);

    List<User> getAllUsers();

    User createUser(User user);
}
