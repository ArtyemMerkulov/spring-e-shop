package com.geekbrains.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private UUID uuid;

    @NotNull
    private String title;

    private CategoryDto category;

    @NotNull
    private BigDecimal price;

    @NotNull
    private BigDecimal weight;

    private String description;

    @NotNull
    private Integer count;

    @NotNull
    private Boolean active;

    @NotNull
    private UserDto createByUser;

    private Timestamp createdAt;

}
