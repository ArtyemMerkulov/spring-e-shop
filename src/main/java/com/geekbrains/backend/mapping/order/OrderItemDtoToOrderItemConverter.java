package com.geekbrains.backend.mapping.order;

import com.geekbrains.backend.dto.OrderItemDto;
import com.geekbrains.backend.persist.Order;
import com.geekbrains.backend.persist.OrderItem;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemDtoToOrderItemConverter extends AbstractConverter<OrderItemDto, OrderItem> {

    private final ModelMapper modelMapper;

    @Autowired
    public OrderItemDtoToOrderItemConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected OrderItem convert(OrderItemDto source) {
        OrderItem orderItem = new OrderItem();

        orderItem.setUuid(source.getUuid());
        orderItem.setOrder(modelMapper.map(source.getOrder(), Order.class));
        orderItem.setTitle(source.getTitle());
        orderItem.setPrice(source.getPrice());
        orderItem.setWeight(source.getWeight());
        orderItem.setCount(source.getCount());

        return orderItem;
    }

}
