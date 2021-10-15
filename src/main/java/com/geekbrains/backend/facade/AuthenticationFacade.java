package com.geekbrains.backend.facade;

import com.geekbrains.backend.dto.UserDto;

import java.util.Optional;

public interface AuthenticationFacade {

    Optional<UserDto> authenticate(String login, String password);

}
