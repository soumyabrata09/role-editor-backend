package com.sam09.roleeditor.services;

import com.sam09.roleeditor.dtos.UserDto;
import com.sam09.roleeditor.repositories.UserRepository;
import com.sam09.roleeditor.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        return userRepository.save(userDto);
    }

    public UserDto getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public  UserDto updateUser(String id, UserDto userDto) {
        return Optional.ofNullable(getUserById(id))
                .map(user -> userRepository.save(user))
                .orElse(null);
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String id) {
        var getUserOptional = Optional.ofNullable(getUserById(id));
        getUserOptional.ifPresentOrElse(
                userDto -> userRepository.deleteById(userDto.getId()),
                () -> ExceptionUtils.invalidIdException(id)
        );
    }
}
