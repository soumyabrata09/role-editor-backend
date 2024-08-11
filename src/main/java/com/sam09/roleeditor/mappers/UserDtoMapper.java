package com.sam09.roleeditor.mappers;

import com.sam09.roleeditor.openapi.models.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserDtoMapper {

    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    @Mapping(target = "firstName", source = "userName")
    UserDto mapToGeneratedDto(com.sam09.roleeditor.dtos.UserDto userDto);

    List<UserDto> mapToGeneratedDtoList(List<com.sam09.roleeditor.dtos.UserDto> userDtoList);
}
