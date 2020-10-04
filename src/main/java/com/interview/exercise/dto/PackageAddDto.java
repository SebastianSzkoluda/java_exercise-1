package com.interview.exercise.dto;

import com.interview.exercise.entities.PackageStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PackageAddDto {

    private PackageStatus packageStatus;
    private Long packageUserToDeliveryFromId;
}
