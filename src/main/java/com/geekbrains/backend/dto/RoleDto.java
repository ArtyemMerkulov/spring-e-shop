package com.geekbrains.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class RoleDto {

    private Integer id;

    @NotNull
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDto roleDto = (RoleDto) o;
        return id.equals(roleDto.id) && title.equals(roleDto.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

}
