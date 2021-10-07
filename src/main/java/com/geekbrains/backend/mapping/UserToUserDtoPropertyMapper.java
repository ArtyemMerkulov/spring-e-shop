package com.geekbrains.backend.mapping;

import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.backend.persist.User;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

@Service
public class UserToUserDtoPropertyMapper extends PropertyMap<User, UserDto> {

    @Override
    protected void configure() {
        map().setUuid(source.getUuid());
        map().setRole(source.getRole());
        map().setEmail(source.getEmail());
        map().setPassword(source.getPassword());
        map().setFirstName(source.getFirstName());
        map().setLastName(source.getLastName());
        map().setPatronymic(source.getPatronymic());
        map().setPhone(source.getPhone());
        map().setAddress(source.getAddress());
        map().setBalance(source.getBalance());
        map().setActive(source.getActive());
        map().setCreatedAt(source.getCreatedAt());
    }

}
