package com.interview.exercise.resource;

import com.interview.exercise.dto.RoleDto;
import com.interview.exercise.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRole(@PathVariable Long id) {
        return roleService.loadRoleById(id)//
                .map(ResponseEntity::ok)//
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<RoleDto> getAllRoles() {
        return roleService.loadAllRoles();
    }

    @PostMapping
    public ResponseEntity<RoleDto> addRole(@RequestParam String roleType) {
        RoleDto roleDto = roleService.addRole(roleType);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()//
                .path("/{id}").buildAndExpand(roleDto.getId())//
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
