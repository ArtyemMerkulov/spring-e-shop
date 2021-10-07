package com.geekbrains.backend.service;

import com.geekbrains.backend.persist.Role;
import com.geekbrains.backend.persist.User;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService {

    List<User> findAll();

    User findByUuid(UUID uuid);

    User save(User user);

    User save(User user, Set<Role> deletedRoles);

    void deleteByUuid(UUID uuid);

}
