package com.geekbrains.backend.service.impl;

import com.geekbrains.backend.persist.Product;
import com.geekbrains.backend.repository.ProductRepository;
import com.geekbrains.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByUuid(UUID uuid) {
        return productRepository.getByUuid(uuid);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Integer deleteByUuid(UUID uuid) {
        return productRepository.deleteByUuid(uuid);
    }

}
