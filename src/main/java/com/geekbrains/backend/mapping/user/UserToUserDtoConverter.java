package com.geekbrains.backend.mapping.user;

import com.geekbrains.backend.dto.RoleDto;
import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.backend.persist.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserToUserDtoConverter extends AbstractConverter<User, UserDto> {

    private final ModelMapper modelMapper;

    @Autowired
    public UserToUserDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected UserDto convert(User source) {
        UserDto userDto = new UserDto();

        userDto.setUuid(source.getUuid());
        userDto.setRoles(source.getRoles()
                               .stream()
                               .map(role -> modelMapper.map(role, RoleDto.class))
                               .collect(Collectors.toSet()));
        userDto.setEmail(source.getEmail());
        userDto.setPassword(source.getPassword());
        userDto.setFirstName(source.getFirstName());
        userDto.setLastName(source.getLastName());
        userDto.setPatronymic(source.getPatronymic());
        userDto.setPhone(source.getPhone());
        userDto.setAddress(source.getAddress());
        userDto.setBalance(source.getBalance());
        userDto.setActive(source.getActive());
        userDto.setCreatedAt(source.getCreatedAt());

        return userDto;
    }

}
