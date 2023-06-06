package com.example.electronicstore.service;

import com.example.electronicstore.dto.UserDto;
import com.example.electronicstore.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
