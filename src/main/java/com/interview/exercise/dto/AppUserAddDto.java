package com.interview.exercise.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUserAddDto {

    private String firstName;
    private String lastName;
    private String company;
    private RoleDto role;
}
