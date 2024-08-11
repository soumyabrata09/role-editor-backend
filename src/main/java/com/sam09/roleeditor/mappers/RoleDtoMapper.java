package com.sam09.roleeditor.mappers;

import com.sam09.roleeditor.openapi.models.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleDtoMapper {

    RoleDtoMapper INSTANCE = Mappers.getMapper(RoleDtoMapper.class);

    RoleDto mapToGeneratedDto(com.sam09.roleeditor.dtos.RoleDto roleDto);

    List<RoleDto> mapToGeneratedDtoList(List<com.sam09.roleeditor.dtos.RoleDto> roleDtos);
}
