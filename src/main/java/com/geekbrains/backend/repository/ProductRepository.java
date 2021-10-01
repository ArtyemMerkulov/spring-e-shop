package com.geekbrains.backend.repository;

import com.geekbrains.backend.persist.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

}
