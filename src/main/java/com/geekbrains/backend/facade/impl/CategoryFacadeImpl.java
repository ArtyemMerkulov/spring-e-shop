package com.geekbrains.backend.facade.impl;

import com.geekbrains.backend.dto.CategoryDto;
import com.geekbrains.backend.facade.CategoryFacade;
import com.geekbrains.backend.persist.Category;
import com.geekbrains.backend.service.CategoryService;
import com.geekbrains.backend.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryFacadeImpl implements CategoryFacade {

    private final EntityToDtoMapper mapper;

    private final CategoryService categoryService;

    @Autowired
    public CategoryFacadeImpl(EntityToDtoMapper mapper,
                              CategoryService categoryService) {
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll()
                .stream()
                .map(category -> mapper.convertToDto(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Integer id) {
        return mapper.convertToDto(categoryService.findById(id), CategoryDto.class);
    }

    @Override
    public void save(CategoryDto categoryDto) {
        categoryService.save(mapper.convertToEntity(categoryDto, Category.class));
    }

    @Override
    public void deleteById(Integer id) {
        categoryService.deleteById(id);
    }

}
