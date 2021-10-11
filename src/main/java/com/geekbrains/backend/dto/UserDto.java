package com.geekbrains.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private UUID uuid;

    private Set<RoleDto> roles;

    @NotNull
    @Email
    private String email;

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

    private Timestamp createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(uuid, userDto.uuid)
                && Objects.equals(roles, userDto.roles)
                && email.equals(userDto.email)
                && Objects.equals(password, userDto.password)
                && firstName.equals(userDto.firstName)
                && lastName.equals(userDto.lastName)
                && Objects.equals(patronymic, userDto.patronymic)
                && Objects.equals(phone, userDto.phone)
                && Objects.equals(address, userDto.address)
                && balance.equals(userDto.balance)
                && active.equals(userDto.active)
                && Objects.equals(createdAt, userDto.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, email, firstName, lastName);
    }

}
