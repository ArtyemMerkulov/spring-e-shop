package com.geekbrains.backend.mapping;

import com.geekbrains.backend.dto.RoleDto;
import com.geekbrains.backend.persist.Role;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

@Service
public class RoleToRoleDtoPropertyMapper extends PropertyMap<Role, RoleDto> {

    @Override
    protected void configure() {
        map().setId(source.getId());
        map().setTitle(source.getTitle());
        map().setUser(source.getUser());
    }

}
