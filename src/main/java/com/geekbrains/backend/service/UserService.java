package com.geekbrains.backend.service;

import com.geekbrains.backend.persist.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<User> findAll();

    User findByUuid(UUID uuid);

    void save(User user);

    void deleteByUuid(UUID uuid);

}
