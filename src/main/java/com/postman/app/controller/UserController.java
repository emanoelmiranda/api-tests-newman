package com.postman.app.controller;

import com.postman.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        value = "/users",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {
    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserResponse> getUser(
            @PathVariable("userId") long userId
    ) {
        log.debug("Received request to get user by userId: {}", userId);

        var user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.OK).body(UserResponse.from(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        log.debug("Received request to get users");

        var users = userService.getAllUsers().stream().map(UserResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody UserRequest payload
    ) {
        log.debug("Received request to create user");

        var user = userService.createUser(payload.toModel());

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.from(user));
    }
}
