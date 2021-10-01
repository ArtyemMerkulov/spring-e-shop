package com.geekbrains.backend.controller;

import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.backend.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserFacade userFacade;

    @Autowired
    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/")
    public List<UserDto> getAll() {
        List<UserDto> userDtos = userFacade.findAll();
        return userDtos != null && !userDtos.isEmpty() ? userDtos : new ArrayList<>(0);
    }

    @PostMapping("/")
    public String create(@Valid UserDto userDto) {
        userFacade.save(userDto);
        return "redirect:/users/";
    }

    @DeleteMapping("/{uuid}")
    public String remove(@PathVariable("uuid") UUID uuid) {
        userFacade.deleteByUuid(uuid);
        return "redirect:/users/";
    }

    @GetMapping("/edit/{uuid}")
    public UserDto getEditPage(@PathVariable("uuid") UUID uuid) {
        return userFacade.findByUuid(uuid);
    }

    @PutMapping("/update")
    public String update(@Valid UserDto userDto) {
        userFacade.save(userDto);
        return "redirect:/users/";
    }

}
