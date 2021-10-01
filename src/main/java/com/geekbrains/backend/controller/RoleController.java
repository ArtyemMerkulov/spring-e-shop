package com.geekbrains.backend.controller;

import com.geekbrains.backend.dto.RoleDto;
import com.geekbrains.backend.facade.RoleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final RoleFacade roleFacade;

    @Autowired
    public RoleController(RoleFacade roleFacade) {
        this.roleFacade = roleFacade;
    }

    @GetMapping("/")
    public List<RoleDto> getAll() {
        List<RoleDto> roleDtos = roleFacade.findAll();
        return roleDtos != null && !roleDtos.isEmpty() ? roleDtos : new ArrayList<>(0);
    }

    @PostMapping("/")
    public String create(@Valid RoleDto roleDto) {
        roleFacade.save(roleDto);
        return "redirect:/roles/";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Integer id) {
        roleFacade.deleteById(id);
        return "redirect:/roles/";
    }

    @GetMapping("/edit/{id}")
    public RoleDto getEditPage(@PathVariable("id") Integer id) {
        return roleFacade.findById(id);
    }

    @PutMapping("/update")
    public String update(@Valid RoleDto roleDto) {
        roleFacade.save(roleDto);
        return "redirect:/roles/";
    }

}
