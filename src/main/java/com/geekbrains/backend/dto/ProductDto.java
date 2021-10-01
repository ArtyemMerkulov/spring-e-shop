package com.geekbrains.backend.dto;

import com.geekbrains.backend.persist.Category;
import com.geekbrains.backend.persist.User;
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

    private Category category;

    @NotNull
    private BigDecimal price;

    @NotNull
    private BigDecimal weight;

    private String description;

    @NotNull
    private Integer count;

    @NotNull
    private User createByUser;

    @NotNull
    private Boolean active;

    @NotNull
    private Timestamp createdAt;

}
