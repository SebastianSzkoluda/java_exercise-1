package com.interview.exercise.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {

    Long id;
    private String roleType;
    private AppUserDto user;
}
