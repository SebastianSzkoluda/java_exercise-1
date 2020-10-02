package com.interview.exercise.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {

    Long id;
    private String roleType;
    private List<AppUserDto> users;
}
