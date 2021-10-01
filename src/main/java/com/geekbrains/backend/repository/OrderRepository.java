package com.geekbrains.backend.repository;

import com.geekbrains.backend.persist.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    Order getByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

}
