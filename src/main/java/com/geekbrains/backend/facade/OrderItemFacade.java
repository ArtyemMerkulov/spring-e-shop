package com.geekbrains.backend.facade;

import com.geekbrains.backend.dto.OrderItemDto;

import java.util.List;
import java.util.UUID;

public interface OrderItemFacade {

    List<OrderItemDto> findAll();

    OrderItemDto findByUuid(UUID uuid);

    void save(OrderItemDto orderItemDto);

    void deleteByUuid(UUID uuid);

    void saveItems(List<OrderItemDto> orderItems);

}
