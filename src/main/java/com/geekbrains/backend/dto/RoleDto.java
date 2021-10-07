package com.geekbrains.backend.dto;

import com.geekbrains.backend.persist.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class RoleDto {

    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private List<User> user;

}
