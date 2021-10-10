package com.geekbrains.backend.mapping.category;

import com.geekbrains.backend.dto.CategoryDto;
import com.geekbrains.backend.dto.ProductDto;
import com.geekbrains.backend.persist.Category;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CategoryToCategoryDtoConverter extends AbstractConverter<Category, CategoryDto> {

    private final ModelMapper modelMapper;

    @Autowired
    public CategoryToCategoryDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected CategoryDto convert(Category source) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(source.getId());
        categoryDto.setTitle(source.getTitle());
        categoryDto.setCreatedAt(source.getCreatedAt());
        categoryDto.setProducts(source.getProducts()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList()));

        return categoryDto;
    }

}
