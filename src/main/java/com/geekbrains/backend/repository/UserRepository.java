package com.geekbrains.backend.repository;

import com.geekbrains.backend.persist.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User getByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

    User findByEmail(String email);

}
