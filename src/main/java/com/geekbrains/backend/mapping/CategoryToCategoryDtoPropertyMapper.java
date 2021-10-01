package com.geekbrains.backend.mapping;

import com.geekbrains.backend.dto.CategoryDto;
import com.geekbrains.backend.persist.Category;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

@Service
public class CategoryToCategoryDtoPropertyMapper extends PropertyMap<Category, CategoryDto> {

    @Override
    protected void configure() {
        map().setId(source.getId());
        map().setTitle(source.getTitle());
        map().setCreatedAt(source.getCreatedAt());
        map().setProducts(source.getProducts());
    }

}
