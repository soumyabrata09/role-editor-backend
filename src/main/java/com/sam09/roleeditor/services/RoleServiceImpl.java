package com.sam09.roleeditor.services;

import com.sam09.roleeditor.dtos.RoleDto;
import com.sam09.roleeditor.mappers.RoleMapper;
import com.sam09.roleeditor.openapi.models.Role;
import com.sam09.roleeditor.repositories.RoleRepository;
import com.sam09.roleeditor.utils.ApplicationConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleDto createRole(Role role) {
        if (Objects.isNull(role) || role.getRoleName().isBlank()) {
            log.error(ApplicationConstants.BLANK_MODEL_MSG);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ApplicationConstants.BLANK_MODEL_MSG);
        }
        return roleRepository.save(RoleMapper.INSTANCE.mapToDto(role));
    }

    @Override
    public RoleDto getRoleById(String id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> {
                    var errMsg = "Unable to get Data, Invalid Id: " + id;
                    log.error(errMsg);
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to get Data, Invalid Id: " + id);
                });
    }

    @Override
    public RoleDto updateRole(Role roleDetails, String id) {
        return Optional.ofNullable(getRoleById(id))
                .map(role -> {
                    if (Objects.isNull(roleDetails) || roleDetails.getRoleName().isBlank()) {
                        log.error(ApplicationConstants.BLANK_MODEL_MSG);
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ApplicationConstants.BLANK_MODEL_MSG);
                    }
                    return roleRepository.save(RoleMapper.INSTANCE.mapToUpdateDto(role.getId(), roleDetails));
                })
                .orElseThrow(() -> {
                    var errMsg = "Unable to update Data, Invalid Id: " + id;
                    log.error(errMsg);
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, errMsg);
                });
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
                () -> {
                    var errMsg = "Unable to delete role, Invalid Id: " + id;
                    log.error(errMsg);
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, errMsg);
                }
        );
    }
}
