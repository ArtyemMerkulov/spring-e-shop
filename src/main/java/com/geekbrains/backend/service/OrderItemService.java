package com.geekbrains.backend.service;

import com.geekbrains.backend.persist.OrderItem;

import java.util.List;
import java.util.UUID;

public interface OrderItemService {

    List<OrderItem> findAll();

    OrderItem findByUuid(UUID uuid);

    void save(OrderItem orderItem);

    void deleteByUuid(UUID uuid);

    void saveItems(List<OrderItem> orderItems);

}
