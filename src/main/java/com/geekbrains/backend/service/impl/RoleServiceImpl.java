package com.geekbrains.backend.service.impl;

import com.geekbrains.backend.persist.Role;
import com.geekbrains.backend.repository.RoleRepository;
import com.geekbrains.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Integer id) {
        return roleRepository.getById(id);
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }

}
