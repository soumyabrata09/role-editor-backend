package com.sam09.roleeditor.services;

import com.sam09.roleeditor.dtos.RoleDto;
import com.sam09.roleeditor.repositories.RoleRepository;
import com.sam09.roleeditor.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public RoleDto createRole(RoleDto roleDto) {
        return roleRepository.save(roleDto);
    }

    public RoleDto getRoleById(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    public RoleDto updateRole(RoleDto roleDto, String id) {
        return Optional.ofNullable(getRoleById(id))
                .map(role -> roleRepository.save(role))
                .orElse(null);
    }

    public List<RoleDto> getRoles() {
        return roleRepository.findAll();
    }

    public void deleteRole(String id) {
        var getRoleOptional = Optional.ofNullable(getRoleById(id));
        getRoleOptional.ifPresentOrElse(
                roleDto -> roleRepository.deleteById(roleDto.getId()),
                () -> ExceptionUtils.invalidIdException(id)
        );
    }
}
