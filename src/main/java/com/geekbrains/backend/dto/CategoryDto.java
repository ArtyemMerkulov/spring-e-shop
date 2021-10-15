package com.geekbrains.backend.dto;

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

    private Timestamp createdAt;

    private List<ProductDto> products;

}
