package com.geekbrains.backend.mapping.order;

import com.geekbrains.backend.dto.OrderItemDto;
import com.geekbrains.backend.dto.ProductDto;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Service;

@Service
public class ProductDtoToOrderItemDto extends AbstractConverter<ProductDto, OrderItemDto> {

    @Override
    protected OrderItemDto convert(ProductDto source) {
        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setTitle(source.getTitle());
        orderItemDto.setPrice(source.getPrice());
        orderItemDto.setWeight(source.getWeight());
        orderItemDto.setCount(source.getCount());

        return orderItemDto;
    }

}
