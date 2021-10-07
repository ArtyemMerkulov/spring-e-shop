package com.geekbrains.backend.service.impl;

import com.geekbrains.backend.persist.User;
import com.geekbrains.backend.repository.UserRepository;
import com.geekbrains.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUuid(UUID uuid) {
        return userRepository.getByUuid(uuid);
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteByUuid(UUID uuid) {
        userRepository.deleteByUuid(uuid);
    }

}
