package com.geekbrains.backend.controller;

import com.geekbrains.backend.dto.ProductDto;
import com.geekbrains.backend.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductFacade productFacade;

    @Autowired
    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping("/")
    public List<ProductDto> getAll() {
        List<ProductDto> productDtos = productFacade.findAll();
        return productDtos != null && !productDtos.isEmpty() ? productDtos : new ArrayList<>(0);
    }

    @PostMapping("/")
    public String create(@Valid ProductDto productDto) {
        productFacade.save(productDto);
        return "redirect:/products/";
    }

    @DeleteMapping("/{uuid}")
    public String remove(@PathVariable("uuid") UUID uuid) {
        productFacade.deleteByUuid(uuid);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{uuid}")
    public ProductDto getEditPage(@PathVariable("uuid") UUID uuid) {
        return productFacade.findByUuid(uuid);
    }

    @PutMapping("/update")
    public String update(@Valid ProductDto productDto) {
        productFacade.save(productDto);
        return "redirect:/products/";
    }

}
