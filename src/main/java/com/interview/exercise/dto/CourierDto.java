package com.interview.exercise.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

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
