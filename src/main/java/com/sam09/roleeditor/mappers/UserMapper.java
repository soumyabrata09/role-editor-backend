package com.sam09.roleeditor.mappers;

import com.sam09.roleeditor.dtos.UserDto;
import com.sam09.roleeditor.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto mapToDto(User user);

    @Mapping(target = "id", source = "userId")
    UserDto mapToUpdateDto(String userId, User user);
}
