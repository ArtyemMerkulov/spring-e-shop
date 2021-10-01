package com.geekbrains.backend.service;

import com.geekbrains.backend.persist.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    List<Order> findAll();

    Order findByUuid(UUID uuid);

    void save(Order order);

    void deleteByUuid(UUID uuid);

}
