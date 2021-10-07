package com.geekbrains.backend.mapping.product;

import com.geekbrains.backend.dto.CategoryDto;
import com.geekbrains.backend.dto.ProductDto;
import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.backend.persist.Product;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductToProductDtoConverter extends AbstractConverter<Product, ProductDto> {

    private final ModelMapper modelMapper;

    @Autowired
    public ProductToProductDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected ProductDto convert(Product source) {
        ProductDto productDto = new ProductDto();

        productDto.setUuid(source.getUuid());
        productDto.setTitle(source.getTitle());
        productDto.setCategory(modelMapper.map(source.getCategory(), CategoryDto.class));
        productDto.setPrice(source.getPrice());
        productDto.setWeight(source.getWeight());
        productDto.setDescription(source.getDescription());
        productDto.setCount(source.getCount());
        productDto.setCreateByUser(modelMapper.map(source.getCreateBy(), UserDto.class));
        productDto.setActive(source.getActive());
        productDto.setCreatedAt(source.getCreatedAt());

        return productDto;
    }

}
