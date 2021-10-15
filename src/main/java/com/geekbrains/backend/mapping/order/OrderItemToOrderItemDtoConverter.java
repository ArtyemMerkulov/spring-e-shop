package com.geekbrains.backend.mapping.order;

import com.geekbrains.backend.dto.OrderDto;
import com.geekbrains.backend.dto.OrderItemDto;
import com.geekbrains.backend.persist.OrderItem;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemToOrderItemDtoConverter extends AbstractConverter<OrderItem, OrderItemDto> {

    private final ModelMapper modelMapper;

    @Autowired
    public OrderItemToOrderItemDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected OrderItemDto convert(OrderItem source) {
        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setUuid(source.getUuid());
        orderItemDto.setOrder(modelMapper.map(source.getOrder(), OrderDto.class));
        orderItemDto.setTitle(source.getTitle());
        orderItemDto.setPrice(source.getPrice());
        orderItemDto.setWeight(source.getWeight());
        orderItemDto.setCount(source.getCount());

        return orderItemDto;
    }

}
