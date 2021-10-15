package com.geekbrains.backend.dto;

import java.util.HashSet;
import java.util.Set;

public class CartDto {

    private final Set<OrderItemDto> items = new HashSet<>(0);

    public OrderItemDto getItem(OrderItemDto item) {
        return items.stream()
                    .filter(item::equals)
                    .findAny()
                    .orElse(null);
    }

    public Set<OrderItemDto> getItems() {
        return items;
    }

    public void addItem(OrderItemDto item) {
        OrderItemDto currentItem = getItem(item);
        if (currentItem != null) {
            currentItem.increment();
        } else {
            item.increment();
            items.add(item);
        }
    }

    public void deleteItem(OrderItemDto item) {
        OrderItemDto currentItem = getItem(item);
        if (currentItem != null) {
            if (item.getTotalCount() > 0) {
                currentItem.decrement();
            } else {
                items.remove(currentItem);
            }
        }
    }

    public void removeItem(OrderItemDto item) {
        items.remove(item);
    }

    public Integer getTotalCount() {
        return items.stream()
                    .mapToInt(OrderItemDto::getTotalCount)
                    .sum();
    }

}
