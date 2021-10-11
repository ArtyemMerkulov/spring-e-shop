package com.geekbrains.backend.mapping.order;

import com.geekbrains.backend.dto.OrderDto;
import com.geekbrains.backend.dto.OrderItemDto;
import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.backend.persist.Order;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderToOrderDtoConverter extends AbstractConverter<Order, OrderDto> {

    private final ModelMapper modelMapper;

    @Autowired
    public OrderToOrderDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected OrderDto convert(Order source) {
        OrderDto orderDto = new OrderDto();

        orderDto.setUuid(source.getUuid());
        orderDto.setUser(modelMapper.map(source.getUser(), UserDto.class));
        orderDto.setPhone(source.getPhone());
        orderDto.setAddress(source.getAddress());
        orderDto.setStatus(source.getStatus());
        orderDto.setCreatedAt(source.getCreatedAt());
        orderDto.setOrderItems(source.getOrderItems()
                .stream()
                .map(orderItem -> modelMapper.map(orderItem, OrderItemDto.class))
                .collect(Collectors.toList()));

        return orderDto;
    }

}
