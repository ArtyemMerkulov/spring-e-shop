package com.geekbrains.backend.dto;

import com.geekbrains.backend.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private UUID uuid;

    @NotNull
    private UserDto user;

    @NotNull
    private String phone;

    private String address;

    @NotNull
    private OrderStatus status;

    private Timestamp createdAt;

    private List<OrderItemDto> orderItems;

}
