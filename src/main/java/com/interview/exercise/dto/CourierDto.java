package com.interview.exercise.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CourierDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String company;
    private LocalDateTime insertTime;
    private AppUserDto client;
    private List<PackageDto> packages;
}
