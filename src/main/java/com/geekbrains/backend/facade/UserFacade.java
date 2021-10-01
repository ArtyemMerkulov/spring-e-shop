package com.geekbrains.backend.facade;

import com.geekbrains.backend.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserFacade {

    List<UserDto> findAll();

    UserDto findByUuid(UUID uuid);

    void save(UserDto userDto);

    void deleteByUuid(UUID uuid);

}
