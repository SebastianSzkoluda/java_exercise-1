package com.interview.exercise.mapper;

import com.interview.exercise.dto.RoleDto;
import com.interview.exercise.entities.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleMapper {

    public static RoleDto mapToDto(Role entity) {
        return RoleDto.builder()
                .id(entity.getId())//
                .roleType(entity.getRoleType())//
                .build();
    }

    public static Role mapToEntity(RoleDto dto) {
        return Role.of(//
                dto.getId(),//
                dto.getRoleType(),
                null
        );
    }
}
