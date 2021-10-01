package com.geekbrains.backend.facade.impl;

import com.geekbrains.backend.dto.OrderItemDto;
import com.geekbrains.backend.facade.OrderItemFacade;
import com.geekbrains.backend.persist.OrderItem;
import com.geekbrains.backend.service.OrderItemService;
import com.geekbrains.backend.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderItemFacadeImpl implements OrderItemFacade {

    private final EntityToDtoMapper mapper;

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemFacadeImpl(EntityToDtoMapper mapper,
                               OrderItemService orderItemService) {
        this.mapper = mapper;
        this.orderItemService = orderItemService;
    }

    @Override
    public List<OrderItemDto> findAll() {
        return orderItemService.findAll()
                .stream()
                .map(orderItem -> mapper.convertToDto(orderItem, OrderItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDto findByUuid(UUID uuid) {
        return mapper.convertToDto(orderItemService.findByUuid(uuid), OrderItemDto.class);
    }

    @Override
    public void save(OrderItemDto orderItemDto) {
        orderItemService.save(mapper.convertToEntity(orderItemDto, OrderItem.class));
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        orderItemService.deleteByUuid(uuid);
    }

    @Override
    public void saveItems(List<OrderItemDto> orderItems) {
        orderItemService.saveItems(orderItems.stream()
                .map(orderItemDto -> mapper.convertToEntity(orderItemDto, OrderItem.class))
                .collect(Collectors.toList()));
    }

}
