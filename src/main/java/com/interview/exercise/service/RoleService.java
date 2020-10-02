package com.interview.exercise.service;

import com.interview.exercise.dto.RoleDto;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<RoleDto> loadRoleById(Long id);

    RoleDto addRole(String roleType);

    List<RoleDto> loadAllRoles();
}
