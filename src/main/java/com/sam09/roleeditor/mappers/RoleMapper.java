package com.sam09.roleeditor.mappers;

import com.sam09.roleeditor.dtos.RoleDto;
import com.sam09.roleeditor.openapi.models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto mapToDto(Role role);

    @Mapping(target = "id", source = "roleId")
    RoleDto mapToUpdateDto(String roleId, Role role);
}
