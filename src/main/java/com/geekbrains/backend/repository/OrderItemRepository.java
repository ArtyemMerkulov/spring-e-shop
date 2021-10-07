package com.geekbrains.backend.repository;

import com.geekbrains.backend.persist.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

    OrderItem getByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

}
