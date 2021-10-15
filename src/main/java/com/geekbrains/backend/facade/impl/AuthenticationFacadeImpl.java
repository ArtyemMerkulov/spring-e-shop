package com.geekbrains.backend.facade.impl;

import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.backend.facade.AuthenticationFacade;
import com.geekbrains.backend.service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    private final ModelMapper modelMapper;
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationFacadeImpl(ModelMapper modelMapper,
                                    AuthenticationService authenticationService) {
        this.modelMapper = modelMapper;
        this.authenticationService = authenticationService;
    }

    @Override
    public Optional<UserDto> authenticate(String login, String password) {
        return authenticationService.authenticate(login, password)
                                    .map(value -> modelMapper.map(value, UserDto.class));
    }

}
