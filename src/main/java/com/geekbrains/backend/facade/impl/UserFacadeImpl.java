package com.geekbrains.backend.facade.impl;

import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.backend.facade.UserFacade;
import com.geekbrains.backend.persist.User;
import com.geekbrains.backend.service.UserService;
import com.geekbrains.backend.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserFacadeImpl implements UserFacade {

    private final EntityToDtoMapper mapper;

    private final UserService userService;

    @Autowired
    public UserFacadeImpl(EntityToDtoMapper mapper,
                          UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll()
                .stream()
                .map(user -> mapper.convertToDto(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findByUuid(UUID uuid) {
        return mapper.convertToDto(userService.findByUuid(uuid), UserDto.class);
    }

    @Override
    public void save(UserDto userDto) {
        userService.save(mapper.convertToEntity(userDto, User.class));
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        userService.deleteByUuid(uuid);
    }

}
