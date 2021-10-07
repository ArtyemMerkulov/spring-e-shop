package com.geekbrains.backend.facade;

import com.geekbrains.backend.dto.RoleDto;
import com.geekbrains.backend.dto.UserDto;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserFacade {

    List<UserDto> findAll();

    UserDto findByUuid(UUID uuid);

    void save(UserDto userDto, Set<RoleDto> deletedRoles);

    void deleteByUuid(UUID uuid);

}
