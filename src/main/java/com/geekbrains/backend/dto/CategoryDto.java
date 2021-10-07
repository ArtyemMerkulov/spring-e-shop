package com.geekbrains.backend.dto;

import com.geekbrains.backend.persist.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private Timestamp createdAt;

    @NotNull
    private List<Product> products;

}
