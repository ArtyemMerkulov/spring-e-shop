package com.geekbrains.backend.facade;

import com.geekbrains.backend.dto.ProductDto;
import com.geekbrains.backend.persist.Product;
import com.geekbrains.backend.service.ProductService;
import com.geekbrains.backend.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductFacadeImpl implements ProductFacade {

    private final EntityToDtoMapper mapper;

    private final ProductService productService;

    @Autowired
    public ProductFacadeImpl(EntityToDtoMapper mapper,
                             ProductService productService) {
        this.mapper = mapper;
        this.productService = productService;
    }

    @Override
    public List<ProductDto> findAll() {
        return productService.findAll()
                .stream()
                .map(product -> mapper.convertToDto(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findByUuid(UUID uuid) {
        return mapper.convertToDto(productService.findByUuid(uuid), ProductDto.class);
    }

    @Override
    public void save(ProductDto productDto) {
        productService.save(mapper.convertToEntity(productDto, Product.class));
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        productService.deleteByUuid(uuid);
    }

}
