package com.geekbrains.backend.service.impl;

import com.geekbrains.backend.persist.Role;
import com.geekbrains.backend.persist.User;
import com.geekbrains.backend.repository.UserRepository;
import com.geekbrains.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
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
    public User save(User user) {
        User updateUser = user.getUuid() != null
                          ? userRepository.getOne(user.getUuid())
                          : new User();

        updateUser.setUuid(user.getUuid());
        updateUser.setRoles(user.getRoles());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setPatronymic(user.getPatronymic());
        updateUser.setPhone(user.getPhone());
        updateUser.setAddress(user.getAddress());
        updateUser.setBalance(user.getBalance());
        updateUser.setActive(user.getActive());
        updateUser.setCreatedAt(user.getCreatedAt());

        return userRepository.save(updateUser);
    }

    @Override
    public User save(User user, Set<Role> deletedRoles) {
        deletedRoles.forEach(user::removeRole);
        return save(user);
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        userRepository.deleteByUuid(uuid);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

}
