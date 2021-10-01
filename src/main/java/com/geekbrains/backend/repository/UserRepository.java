package com.geekbrains.backend.repository;

import com.geekbrains.backend.persist.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

}
