package com.geekbrains.backend.service;

import com.geekbrains.backend.persist.User;

import java.util.Optional;

public interface AuthenticationService {

    Optional<User> authenticate(String login, String password);

}