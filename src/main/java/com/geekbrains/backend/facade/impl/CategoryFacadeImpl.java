package com.geekbrains.backend.facade.impl;

import com.geekbrains.backend.dto.CategoryDto;
import com.geekbrains.backend.facade.CategoryFacade;
import com.geekbrains.backend.persist.Category;
import com.geekbrains.backend.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryFacadeImpl implements CategoryFacade {

    private final ModelMapper modelMapper;

    private final CategoryService categoryService;

    @Autowired
    public CategoryFacadeImpl(ModelMapper modelMapper,
                              CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Integer id) {
        return modelMapper.map(categoryService.findById(id), CategoryDto.class);
    }

    @Override
    public void save(CategoryDto categoryDto) {
        categoryService.save(modelMapper.map(categoryDto, Category.class));
    }

    @Override
    public void deleteById(Integer id) {
        categoryService.deleteById(id);
    }

}
