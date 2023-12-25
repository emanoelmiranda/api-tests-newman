package com.postman.app.service;

import com.postman.app.model.User;
import com.postman.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserById(long userId) {
        return repository.findById(userId).get();
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }
}
