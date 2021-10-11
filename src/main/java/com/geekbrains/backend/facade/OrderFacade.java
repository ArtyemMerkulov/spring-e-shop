package com.geekbrains.backend.facade;

import com.geekbrains.backend.dto.OrderDto;

import java.util.List;
import java.util.UUID;

public interface OrderFacade {

    List<OrderDto> findAll();

    OrderDto findByUuid(UUID uuid);

    void save(OrderDto orderDto);

    void deleteByUuid(UUID uuid);

}