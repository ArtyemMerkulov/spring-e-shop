package com.geekbrains.backend.facade.impl;

import com.geekbrains.backend.dto.OrderDto;
import com.geekbrains.backend.facade.OrderFacade;
import com.geekbrains.backend.persist.Order;
import com.geekbrains.backend.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderFacadeImpl implements OrderFacade {

    private final ModelMapper modelMapper;

    private final OrderService orderService;

    @Autowired
    public OrderFacadeImpl(ModelMapper modelMapper,
                           OrderService orderService) {
        this.modelMapper = modelMapper;
        this.orderService = orderService;
    }

    @Override
    public List<OrderDto> findAll() {
        return orderService.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findByUuid(UUID uuid) {
        return modelMapper.map(orderService.findByUuid(uuid), OrderDto.class);
    }

    @Override
    public void save(OrderDto orderDto) {
        orderService.save(modelMapper.map(orderDto, Order.class));
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        orderService.deleteByUuid(uuid);
    }

}
