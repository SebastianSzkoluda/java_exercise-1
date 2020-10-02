package com.interview.exercise.service.impl;

import com.interview.exercise.dto.RoleDto;
import com.interview.exercise.entities.Role;
import com.interview.exercise.mapper.RoleMapper;
import com.interview.exercise.repository.RoleRepository;
import com.interview.exercise.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<RoleDto> loadRoleById(Long id) {
        return roleRepository.findById(id)//
                .map(RoleMapper::mapToDto);
    }

    @Override
    public RoleDto addRole(String roleType) {
        Role role = Role.of(null, roleType, null);
        Role savedRole = roleRepository.save(role);
        return RoleMapper.mapToDto(savedRole);
    }

    @Override
    public List<RoleDto> loadAllRoles() {
        return roleRepository.findAll().stream()//
                .map(RoleMapper::mapToDto)//
                .collect(Collectors.toList());
    }
}
