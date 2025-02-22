package com.sam09.roleeditor.services;

import com.sam09.roleeditor.openapi.models.Role;
import com.sam09.roleeditor.dtos.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto createRole(Role role);

    RoleDto getRoleById(String id);

    RoleDto updateRole(Role roleDetails, String id);

    List<RoleDto> getRoles();

    void deleteRole(String id);
}
