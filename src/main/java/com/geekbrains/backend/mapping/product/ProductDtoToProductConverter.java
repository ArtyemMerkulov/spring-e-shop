package com.geekbrains.backend.mapping.product;

import com.geekbrains.backend.dto.ProductDto;
import com.geekbrains.backend.persist.Category;
import com.geekbrains.backend.persist.Product;
import com.geekbrains.backend.persist.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDtoToProductConverter extends AbstractConverter<ProductDto, Product> {

    private final ModelMapper modelMapper;

    @Autowired
    public ProductDtoToProductConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected Product convert(ProductDto source) {
        Product product = new Product();

        product.setUuid(source.getUuid());
        product.setTitle(source.getTitle());
        product.setCategory(modelMapper.map(source.getCategory(), Category.class));
        product.setPrice(source.getPrice());
        product.setWeight(source.getWeight());
        product.setDescription(source.getDescription());
        product.setCount(source.getCount());
        product.setCreateBy(modelMapper.map(source.getCreateByUser(), User.class));
        product.setActive(source.getActive());
        product.setCreatedAt(source.getCreatedAt());

        return product;
    }

}
