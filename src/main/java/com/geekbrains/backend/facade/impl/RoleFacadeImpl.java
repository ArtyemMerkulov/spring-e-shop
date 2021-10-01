package com.geekbrains.backend.facade.impl;

import com.geekbrains.backend.dto.RoleDto;
import com.geekbrains.backend.facade.RoleFacade;
import com.geekbrains.backend.persist.Role;
import com.geekbrains.backend.service.RoleService;
import com.geekbrains.backend.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleFacadeImpl implements RoleFacade {

    private final EntityToDtoMapper mapper;

    private final RoleService roleService;

    @Autowired
    public RoleFacadeImpl(EntityToDtoMapper mapper,
                          RoleService roleService) {
        this.mapper = mapper;
        this.roleService = roleService;
    }

    @Override
    public List<RoleDto> findAll() {
        return roleService.findAll()
                .stream()
                .map(role -> mapper.convertToDto(role, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(Integer id) {
        return mapper.convertToDto(roleService.findById(id), RoleDto.class);
    }

    @Override
    public void save(RoleDto roleDto) {
        roleService.save(mapper.convertToEntity(roleDto, Role.class));
    }

    @Override
    public void deleteById(Integer id) {
        roleService.deleteById(id);
    }

}
