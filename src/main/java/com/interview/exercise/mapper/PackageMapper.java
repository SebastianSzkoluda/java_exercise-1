package com.interview.exercise.mapper;

import com.interview.exercise.dto.PackageDto;
import com.interview.exercise.entities.Package;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PackageMapper {

    public static PackageDto mapToDto(Package entity) {
        return PackageDto.builder()//
                .id(entity.getId())//
                .packageStatus(entity.getStatus())//
                .courier(CourierMapper.mapToDto(entity.getCourier()))//
                .packageUserToDeliveryFrom(AppUserMapper.mapToDto(entity.getPackageUserToDeliveryFrom()))//
                .build();
    }

    public static Package mapToEntity(PackageDto dto) {
        return Package.of(//
                dto.getId(),//
                dto.getPackageStatus(),//
                AppUserMapper.mapToEntity(dto.getPackageUserToDeliveryFrom()),//
                CourierMapper.mapToEntity(dto.getCourier())//
        );
    }
}
