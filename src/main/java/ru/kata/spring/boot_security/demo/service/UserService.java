package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UserService {
    public Iterable<UserEntity> getAllUsers();

    Optional<UserEntity> findByEmail(String email);

    public UserEntity getInfoByEmail(String email);

    public void save(UserEntity user);

    public void update(UserEntity user);

    public void delete(Long id);
}
