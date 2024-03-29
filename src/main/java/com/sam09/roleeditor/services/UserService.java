package com.sam09.roleeditor.services;

import com.sam09.roleeditor.dtos.UserDto;
import com.sam09.roleeditor.models.User;

import java.util.List;

public interface UserService {

    UserDto createUser(User user);

    UserDto getUserById(String id);

    UserDto updateUser(String id, User userDetails);

    List<UserDto> getUsers();

    void deleteUser(String id);
}
