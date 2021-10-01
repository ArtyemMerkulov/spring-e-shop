package com.geekbrains.backend.mapping;

import com.geekbrains.backend.dto.OrderItemDto;
import com.geekbrains.backend.persist.OrderItem;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

@Service
public class OrderItemToOrderItemDtoPropertyMapper extends PropertyMap<OrderItem, OrderItemDto> {

    @Override
    protected void configure() {
        map().setUuid(source.getUuid());
        map().setOrder(source.getOrder());
        map().setTitle(source.getTitle());
        map().setPrice(source.getPrice());
        map().setWeight(source.getWeight());
        map().setCount(source.getCount());
    }

}
