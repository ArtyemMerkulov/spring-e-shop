package com.geekbrains.backend.controller;

import com.geekbrains.backend.dto.CategoryDto;
import com.geekbrains.backend.facade.CategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryFacade categoryFacade;

    @Autowired
    public CategoryController(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @GetMapping("/")
    public List<CategoryDto> getAll() {
        List<CategoryDto> categoryDtos = categoryFacade.findAll();
        return categoryDtos != null && !categoryDtos.isEmpty() ? categoryDtos : new ArrayList<>(0);
    }

    @PostMapping("/")
    public String create(@Valid CategoryDto categoryDto) {
        categoryFacade.save(categoryDto);
        return "redirect:/categories/";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Integer id) {
        categoryFacade.deleteById(id);
        return "redirect:/categories/";
    }

    @GetMapping("/edit/{id}")
    public CategoryDto getEditPage(@PathVariable("id") Integer id) {
        return categoryFacade.findById(id);
    }

    @PutMapping("/update")
    public String update(@Valid CategoryDto categoryDto) {
        categoryFacade.save(categoryDto);
        return "redirect:/categories/";
    }

}
