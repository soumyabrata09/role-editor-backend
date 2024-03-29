package com.sam09.roleeditor.services;

import com.sam09.roleeditor.dtos.RoleDto;
import com.sam09.roleeditor.openapi.models.Role;
import com.sam09.roleeditor.mappers.RoleMapper;
import com.sam09.roleeditor.repositories.RoleRepository;
import com.sam09.roleeditor.utils.ExceptionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleDto createRole(Role role) {
        return roleRepository.save(RoleMapper.INSTANCE.mapToDto(role));
    }

    @Override
    public RoleDto getRoleById(String id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> ExceptionUtils.invalidIdException(id, "Unable to get Data, Invalid Id"));
    }

    @Override
    public RoleDto updateRole(Role roleDetails, String id) {
        return Optional.ofNullable(getRoleById(id))
                .map(role -> roleRepository.save(RoleMapper.INSTANCE.mapToUpdateDto(role.getId(), roleDetails)))
                .orElseThrow(() -> ExceptionUtils.invalidIdException(id, "Unable to update role, Invalid Id"));
    }

    @Override
    public List<RoleDto> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteRole(String id) {
        var getRoleOptional = Optional.ofNullable(getRoleById(id));
        getRoleOptional.ifPresentOrElse(
                roleDto -> roleRepository.deleteById(roleDto.getId()),
                () -> ExceptionUtils.invalidIdException(id, "Unable to delete role, Invalid Id")
        );
    }
}
