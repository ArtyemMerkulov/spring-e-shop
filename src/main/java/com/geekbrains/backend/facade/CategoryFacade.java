package com.geekbrains.backend.facade;

import com.geekbrains.backend.dto.CategoryDto;

import java.util.List;

public interface CategoryFacade {

    List<CategoryDto> findAll();

    CategoryDto findById(Integer id);

    void save(CategoryDto categoryDto);

    void deleteById(Integer id);

}
