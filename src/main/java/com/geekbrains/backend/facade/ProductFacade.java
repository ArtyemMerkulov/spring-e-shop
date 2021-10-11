package com.geekbrains.backend.facade;

import com.geekbrains.backend.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductFacade {

    List<ProductDto> findAll();

    ProductDto findByUuid(UUID uuid);

    void save(ProductDto userDto);

    Integer deleteByUuid(UUID uuid);

}
