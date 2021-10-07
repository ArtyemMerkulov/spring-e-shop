package com.geekbrains.backend.mapping.role;

import com.geekbrains.backend.dto.RoleDto;
import com.geekbrains.backend.persist.Role;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Service;

@Service
public class RoleDtoToRoleConverter extends AbstractConverter<RoleDto, Role> {

    @Override
    protected Role convert(RoleDto source) {
        Role role = new Role();

        role.setId(source.getId());
        role.setTitle(source.getTitle());

        return role;
    }

}
