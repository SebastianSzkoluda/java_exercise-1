package com.interview.exercise.mapper;

import com.interview.exercise.dto.RoleDto;
import com.interview.exercise.entities.Role;

public interface RoleMapper {

    public Role roleDtoToRole(RoleDto roleDto);

    public default String nameToUpper(RoleDto roleDto) {
        return roleDto.getName().toUpperCase();
    }
}
