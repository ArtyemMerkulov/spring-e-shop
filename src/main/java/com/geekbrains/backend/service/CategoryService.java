package com.geekbrains.backend.service;

import com.geekbrains.backend.persist.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);

}
