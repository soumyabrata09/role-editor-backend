package com.sam09.roleeditor.resources;

import com.sam09.roleeditor.mappers.RoleDtoMapper;
import com.sam09.roleeditor.openapi.models.Role;
import com.sam09.roleeditor.openapi.models.RoleDto;
import com.sam09.roleeditor.openapi.resources.RoleApi;
import com.sam09.roleeditor.services.RoleService;
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
@RequestMapping("/role")
@CrossOrigin(origins = CROSS_ORIGIN_VALUE)
//@Tag(name = "Role CRUD Operations", description = "Role editor APIs")
public class RoleController implements RoleApi {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDto> createRole(@RequestBody Role role) {
        var mappedRole = RoleDtoMapper.INSTANCE.mapToGeneratedDto(roleService.createRole(role));
        return new ResponseEntity<>(mappedRole, HttpStatus.CREATED);
    }

    @Override
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDto> updateRole(@RequestBody Role role) {
        var mappedRole = RoleDtoMapper.INSTANCE.mapToGeneratedDto(roleService.updateRole(role, role.getId()));
        return new ResponseEntity<>(mappedRole, HttpStatus.ACCEPTED);
    }

    @Override
    @GetMapping(path = "/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDto> getRoleById(@PathVariable String roleId) {
        var mappedRole = RoleDtoMapper.INSTANCE.mapToGeneratedDto(roleService.getRoleById(roleId));
        return new ResponseEntity<>(mappedRole, HttpStatus.OK);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleDto>> getRoles() {
        var mappedList = RoleDtoMapper.INSTANCE.mapToGeneratedDtoList(roleService.getRoles());
        return new ResponseEntity<>(mappedList, HttpStatus.OK);
    }

    @Override
    @DeleteMapping(path = "/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable String roleId) {
        roleService.deleteRole(roleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
