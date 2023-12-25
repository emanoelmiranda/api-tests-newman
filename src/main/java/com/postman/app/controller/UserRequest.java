package com.postman.app.controller;

import com.postman.app.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String email;

    public User toModel() {
        return new User(name, email);
    }
}
