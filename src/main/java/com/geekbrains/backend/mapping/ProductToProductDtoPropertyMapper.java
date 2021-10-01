package com.geekbrains.backend.mapping;

import com.geekbrains.backend.dto.ProductDto;
import com.geekbrains.backend.persist.Product;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

@Service
public class ProductToProductDtoPropertyMapper extends PropertyMap<Product, ProductDto> {

    @Override
    protected void configure() {
        map().setUuid(source.getUuid());
        map().setTitle(source.getTitle());
        map().setCategory(source.getCategory());
        map().setPrice(source.getPrice());
        map().setWeight(source.getWeight());
        map().setDescription(source.getDescription());
        map().setCount(source.getCount());
        map().setCreateByUser(source.getCreateByUser());
        map().setActive(source.getActive());
        map().setCreatedAt(source.getCreatedAt());
    }

}
