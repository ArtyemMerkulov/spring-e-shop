package com.geekbrains.backend.mapping;

import com.geekbrains.backend.dto.OrderDto;
import com.geekbrains.backend.dto.OrderItemDto;
import com.geekbrains.backend.persist.Order;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderToOrderDtoPropertyMapper extends PropertyMap<Order, OrderDto> {

    @Override
    protected void configure() {
        map().setUuid(source.getUuid());
        map().setUser(source.getUser());
        map().setPhone(source.getPhone());
        map().setAddress(source.getAddress());
        map().setStatus(source.getStatus());
        map().setCreatedAt(source.getCreatedAt());
        map().setOrderItems(source.getOrderItems().stream()
                .map(orderItem -> {
                    OrderItemDto orderItemDto = new OrderItemDto();

                    orderItemDto.setUuid(orderItem.getUuid());
                    orderItemDto.setOrder(orderItem.getOrder());
                    orderItemDto.setTitle(orderItem.getTitle());
                    orderItemDto.setPrice(orderItem.getPrice());
                    orderItemDto.setWeight(orderItem.getWeight());
                    orderItemDto.setCount(orderItemDto.getCount());

                    return orderItemDto;
                })
                .collect(Collectors.toList()));
    }

}
