package com.geekbrains.backend.mapping.category;

import com.geekbrains.backend.dto.CategoryDto;
import com.geekbrains.backend.persist.Category;
import com.geekbrains.backend.persist.Product;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CategoryDtoToCategoryConverter extends AbstractConverter<CategoryDto, Category> {

    private final ModelMapper modelMapper;

    @Autowired
    public CategoryDtoToCategoryConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected Category convert(CategoryDto source) {
        Category category = new Category();

        category.setId(source.getId());
        category.setTitle(source.getTitle());
        category.setCreatedAt(source.getCreatedAt());
        category.setProducts(source.getProducts()
                .stream()
                .map(productDto -> modelMapper.map(productDto, Product.class))
                .collect(Collectors.toList()));

        return category;
    }

}
