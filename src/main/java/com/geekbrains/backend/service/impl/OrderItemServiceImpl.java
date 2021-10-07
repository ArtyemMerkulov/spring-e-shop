package com.geekbrains.backend.service.impl;

import com.geekbrains.backend.persist.OrderItem;
import com.geekbrains.backend.repository.OrderItemRepository;
import com.geekbrains.backend.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem findByUuid(UUID uuid) {
        return orderItemRepository.getByUuid(uuid);
    }

    @Override
    @Transactional
    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    @Transactional
    public void deleteByUuid(UUID uuid) {
        orderItemRepository.deleteByUuid(uuid);
    }

    @Override
    @Transactional
    public void saveItems(List<OrderItem> orderItems) {
        orderItemRepository.saveAll(orderItems);
    }

}
