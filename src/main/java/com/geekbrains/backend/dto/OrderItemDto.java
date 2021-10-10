package com.geekbrains.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class OrderItemDto {

    private UUID uuid;

    private OrderDto order;

    @NotNull
    private String title;

    @NotNull
    private BigDecimal price;

    @NotNull
    private BigDecimal weight;

    @NotNull
    private Integer count;

    @NotNull
    private BigDecimal totalPrice = new BigDecimal(0);

    @NotNull
    private BigDecimal totalWeight = new BigDecimal(0);

    @NotNull
    private Integer totalCount = 0;

    public void increment() {
        totalPrice = totalPrice.add(price);
        totalWeight = totalWeight.add(weight);
        totalCount++;
    }

    public void decrement() {
        if (totalCount > 0) {
            totalPrice = totalPrice.subtract(price);
            totalWeight = totalWeight.subtract(weight);
            totalCount--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemDto that = (OrderItemDto) o;
        return Objects.equals(uuid, that.uuid)
                && Objects.equals(order, that.order)
                && title.equals(that.title)
                && price.equals(that.price)
                && weight.equals(that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, order, title, price, weight);
    }

}
