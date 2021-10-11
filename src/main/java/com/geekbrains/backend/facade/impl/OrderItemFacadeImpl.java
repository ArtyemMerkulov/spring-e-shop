package com.geekbrains.backend.facade.impl;

import com.geekbrains.backend.dto.OrderItemDto;
import com.geekbrains.backend.facade.OrderItemFacade;
import com.geekbrains.backend.persist.OrderItem;
import com.geekbrains.backend.service.OrderItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderItemFacadeImpl implements OrderItemFacade {

    private final ModelMapper modelMapper;

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemFacadeImpl(ModelMapper modelMapper,
                               OrderItemService orderItemService) {
        this.modelMapper = modelMapper;
        this.orderItemService = orderItemService;
    }

    @Override
    public List<OrderItemDto> findAll() {
        return orderItemService.findAll()
                .stream()
                .map(orderItem -> modelMapper.map(orderItem, OrderItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDto findByUuid(UUID uuid) {
        return modelMapper.map(orderItemService.findByUuid(uuid), OrderItemDto.class);
    }

    @Override
    public void save(OrderItemDto orderItemDto) {
        orderItemService.save(modelMapper.map(orderItemDto, OrderItem.class));
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        orderItemService.deleteByUuid(uuid);
    }

    @Override
    public void saveItems(List<OrderItemDto> orderItems) {
        orderItemService.saveItems(orderItems.stream()
                .map(orderItemDto -> modelMapper.map(orderItemDto, OrderItem.class))
                .collect(Collectors.toList()));
    }

}
