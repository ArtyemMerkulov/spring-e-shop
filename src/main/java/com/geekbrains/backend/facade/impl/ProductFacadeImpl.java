package com.geekbrains.backend.facade.impl;

import com.geekbrains.backend.dto.ProductDto;
import com.geekbrains.backend.facade.ProductFacade;
import com.geekbrains.backend.persist.Product;
import com.geekbrains.backend.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductFacadeImpl implements ProductFacade {

    private final ModelMapper modelMapper;

    private final ProductService productService;

    @Autowired
    public ProductFacadeImpl(ModelMapper modelMapper,
                             ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @Override
    @Transactional
    public List<ProductDto> findAll() {
        return productService.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductDto findByUuid(UUID uuid) {
        return modelMapper.map(productService.findByUuid(uuid), ProductDto.class);
    }

    @Override
    @Transactional
    public void save(ProductDto productDto) {
        productService.save(modelMapper.map(productDto, Product.class));
    }

    @Override
    @Transactional
    public Integer deleteByUuid(UUID uuid) {
        return productService.deleteByUuid(uuid);
    }

}
