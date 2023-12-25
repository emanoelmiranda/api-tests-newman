package com.postman.app.controller;

import com.postman.app.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private final long id;
    private final String name;
    private final String email;

    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}
