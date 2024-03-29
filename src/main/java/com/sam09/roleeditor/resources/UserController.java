package com.sam09.roleeditor.resources;

import com.sam09.roleeditor.mappers.UserDtoMapper;
import com.sam09.roleeditor.openapi.models.User;
import com.sam09.roleeditor.openapi.models.UserDto;
import com.sam09.roleeditor.openapi.resources.UserApi;
import com.sam09.roleeditor.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.sam09.roleeditor.utils.ApplicationConstants.CROSS_ORIGIN_VALUE;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = CROSS_ORIGIN_VALUE)
//@Tag(name = "User CRUD Operations", description = "User editor APIs")
public class UserController implements UserApi {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
        var mappedUser = UserDtoMapper.INSTANCE.mapToGeneratedDto(userService.createUser(user));
        return new ResponseEntity<>(mappedUser, HttpStatus.CREATED);
    }

    @Override
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> updateUser(@RequestBody User user) {
        var mappedUser = UserDtoMapper.INSTANCE.mapToGeneratedDto(userService.updateUser(user.getId(), user));
        return new ResponseEntity<>(mappedUser, HttpStatus.ACCEPTED);
    }

    @Override
    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {
        var mappedUser = UserDtoMapper.INSTANCE.mapToGeneratedDto(userService.getUserById(userId));
        return new ResponseEntity<>(mappedUser, HttpStatus.OK);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> getUsers() {
        var mappedList = UserDtoMapper.INSTANCE.mapToGeneratedDtoList(userService.getUsers());
        return new ResponseEntity<>(mappedList, HttpStatus.OK);
    }

    @Override
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
