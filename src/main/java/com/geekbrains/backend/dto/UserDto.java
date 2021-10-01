package com.geekbrains.backend.dto;

import com.geekbrains.backend.persist.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private UUID uuid;

    @NotNull
    private Role role;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String patronymic;

    private String phone;

    private String address;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private Boolean active;

    @NotNull
    private Timestamp createdAt;

}
