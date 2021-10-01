package com.geekbrains.backend.dto;

import com.geekbrains.backend.persist.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class OrderItemDto {

    private UUID uuid;

    @NotNull
    private Order order;

    @NotNull
    private String title;

    @NotNull
    private BigDecimal price;

    @NotNull
    private BigDecimal weight;

    @NotNull
    private Integer count;

}
