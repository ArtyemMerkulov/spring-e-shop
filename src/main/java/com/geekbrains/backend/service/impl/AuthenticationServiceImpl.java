package com.geekbrains.backend.service.impl;

import com.geekbrains.backend.persist.User;
import com.geekbrains.backend.service.AuthenticationService;
import com.geekbrains.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<User> authenticate(String login, String password) {
        return userService.findByEmailAndPassword(login, password);
    }

}
