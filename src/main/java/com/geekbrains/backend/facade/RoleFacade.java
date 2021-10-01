package com.geekbrains.backend.facade;

import com.geekbrains.backend.dto.RoleDto;

import java.util.List;

public interface RoleFacade {

    List<RoleDto> findAll();

    RoleDto findById(Integer id);

    void save(RoleDto roleDto);

    void deleteById(Integer id);

}
