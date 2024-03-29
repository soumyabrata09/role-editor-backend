package com.sam09.roleeditor.mappers;

import com.sam09.roleeditor.dtos.UserDto;
import com.sam09.roleeditor.openapi.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userName", source = "firstName")
    UserDto mapToDto(User user);

    @Mapping(target = "id", source = "userId")
    @Mapping(target = "userName", source = "user.firstName")
    UserDto mapToUpdateDto(String userId, User user);
}
