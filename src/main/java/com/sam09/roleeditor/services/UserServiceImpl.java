package com.sam09.roleeditor.services;

import com.sam09.roleeditor.dtos.UserDto;
import com.sam09.roleeditor.mappers.UserMapper;
import com.sam09.roleeditor.openapi.models.User;
import com.sam09.roleeditor.repositories.UserRepository;
import com.sam09.roleeditor.utils.ExceptionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(User user) {
        return userRepository.save(UserMapper.INSTANCE.mapToDto(user));
    }

    @Override
    public UserDto getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public  UserDto updateUser(String id, User userDetails) {
        return Optional.ofNullable(getUserById(id))
                .map(user -> userRepository.save(
                        UserMapper.INSTANCE.mapToUpdateDto(user.getId(), userDetails)))
                .orElse(null);
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        var getUserOptional = Optional.ofNullable(getUserById(id));
        getUserOptional.ifPresentOrElse(
                userDto -> userRepository.deleteById(userDto.getId()),
                () -> ExceptionUtils.invalidIdException(id)
        );
    }
}
