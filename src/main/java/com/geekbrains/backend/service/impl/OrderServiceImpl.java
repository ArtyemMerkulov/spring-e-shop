package com.geekbrains.backend.service.impl;

import com.geekbrains.backend.persist.Order;
import com.geekbrains.backend.repository.OrderRepository;
import com.geekbrains.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findByUuid(UUID uuid) {
        return orderRepository.getByUuid(uuid);
    }

    @Override
    @Transactional
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void deleteByUuid(UUID uuid) {
        orderRepository.deleteByUuid(uuid);
    }

}
