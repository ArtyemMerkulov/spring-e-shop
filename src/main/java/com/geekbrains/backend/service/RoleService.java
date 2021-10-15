package com.geekbrains.backend.service;

import com.geekbrains.backend.persist.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(Integer id);

    void save(Role role);

    void deleteById(Integer id);

    Role getByTitle(String title);

}
