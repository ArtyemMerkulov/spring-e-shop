package com.geekbrains.backend.facade.impl;

import com.geekbrains.backend.dto.RoleDto;
import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.backend.facade.UserFacade;
import com.geekbrains.backend.persist.Role;
import com.geekbrains.backend.persist.User;
import com.geekbrains.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserFacadeImpl implements UserFacade {

    private final ModelMapper modelMapper;

    private final UserService userService;

    @Autowired
    public UserFacadeImpl(ModelMapper modelMapper,
                          UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    @Transactional
    public List<UserDto> findAll() {
        return userService.findAll()
                          .stream()
                          .map(user -> modelMapper.map(user, UserDto.class))
                          .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDto findByUuid(UUID uuid) {
        return modelMapper.map(userService.findByUuid(uuid), UserDto.class);
    }

    @Override
    @Transactional
    public void save(UserDto userDto) {
        userService.save(modelMapper.map(userDto, User.class));
    }

    @Override
    @Transactional
    public void save(UserDto userDto, Set<RoleDto> deletedRoles) {
        userService.save(modelMapper.map(userDto, User.class),
                         deletedRoles.stream()
                                     .map(deletedRole -> modelMapper.map(deletedRole, Role.class))
                                     .collect(Collectors.toSet()));
    }

    @Override
    @Transactional
    public void deleteByUuid(UUID uuid) {
        userService.deleteByUuid(uuid);
    }

    @Override
    @Transactional
    public UserDto findByEmail(String email) {
        return modelMapper.map(userService.findByEmail(email), UserDto.class);
    }

}
