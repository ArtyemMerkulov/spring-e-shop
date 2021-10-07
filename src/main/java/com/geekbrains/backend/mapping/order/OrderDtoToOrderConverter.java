package com.geekbrains.backend.mapping.order;

import com.geekbrains.backend.dto.OrderDto;
import com.geekbrains.backend.persist.Order;
import com.geekbrains.backend.persist.OrderItem;
import com.geekbrains.backend.persist.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderDtoToOrderConverter extends AbstractConverter<OrderDto, Order> {

    private final ModelMapper modelMapper;

    @Autowired
    public OrderDtoToOrderConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected Order convert(OrderDto source) {
        Order order = new Order();

        order.setUuid(source.getUuid());
        order.setUser(modelMapper.map(source.getUser(), User.class));
        order.setPhone(source.getPhone());
        order.setAddress(source.getAddress());
        order.setStatus(source.getStatus());
        order.setCreatedAt(source.getCreatedAt());
        order.setOrderItems(source.getOrderItems()
                .stream()
                .map(orderItemDto -> modelMapper.map(orderItemDto, OrderItem.class))
                .collect(Collectors.toList()));

        return order;
    }

}
