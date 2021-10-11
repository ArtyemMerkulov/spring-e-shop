package com.geekbrains.backend.service;

import com.geekbrains.backend.persist.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> findAll();

    Product findByUuid(UUID uuid);

    void save(Product product);

    Integer deleteByUuid(UUID uuid);

}
