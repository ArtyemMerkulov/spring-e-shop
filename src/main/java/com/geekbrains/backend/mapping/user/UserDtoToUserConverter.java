package com.geekbrains.backend.mapping.user;

import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.backend.persist.Role;
import com.geekbrains.backend.persist.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDtoToUserConverter extends AbstractConverter<UserDto, User> {

    private final ModelMapper modelMapper;

    @Autowired
    public UserDtoToUserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected User convert(UserDto source) {
        User user = new User();

        user.setUuid(source.getUuid());
        source.getRoles().forEach(role -> user.addRole(modelMapper.map(role, Role.class)));
        user.setEmail(source.getEmail());
        user.setPassword(source.getPassword());
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setPatronymic(source.getPatronymic());
        user.setPhone(source.getPhone());
        user.setAddress(source.getAddress());
        user.setBalance(source.getBalance());
        user.setActive(source.getActive());
        user.setCreatedAt(source.getCreatedAt());

        return user;
    }

}
