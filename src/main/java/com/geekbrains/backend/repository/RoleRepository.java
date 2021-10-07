package com.geekbrains.backend.repository;

import com.geekbrains.backend.persist.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role getById(Integer id);

    void deleteById(Integer id);

}
