package com.geekbrains.backend.mapping.role;

import com.geekbrains.backend.dto.RoleDto;
import com.geekbrains.backend.persist.Role;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Service;

@Service
public class RoleToRoleDtoConverter extends AbstractConverter<Role, RoleDto> {

    @Override
    protected RoleDto convert(Role source) {
        RoleDto roleDto = new RoleDto();

        roleDto.setId(source.getId());
        roleDto.setTitle(source.getTitle());

        return roleDto;
    }

}
