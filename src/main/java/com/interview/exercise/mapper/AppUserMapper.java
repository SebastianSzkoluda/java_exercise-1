package com.interview.exercise.mapper;

import com.interview.exercise.dto.AppUserAddDto;
import com.interview.exercise.dto.AppUserDto;
import com.interview.exercise.entities.AppUser;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppUserMapper {

    public static AppUserDto mapToDto(AppUser entity) {
        return AppUserDto.builder()//
                .id(entity.getId())//
                .company(entity.getCompany())//
                .firstName(entity.getFirstName())//
                .lastName(entity.getLastName())//
                .insertTime(entity.getInsertTime())//
                .courier(CourierMapper.mapToDto(entity.getCourier()))//
                .packages(entity.getPackages().stream().map(PackageMapper::mapToDto).collect(Collectors.toList()))//
                .role(RoleMapper.mapToDto(entity.getRole()))//
                .build();
    }

    public static AppUser mapToEntity(AppUserDto dto) {
        return AppUser.of(//
                dto.getId(),//
                dto.getCompany(),//
                dto.getFirstName(),//
                dto.getLastName(),//
                dto.getInsertTime(),//
                RoleMapper.mapToEntity(dto.getRole()),//
                dto.getPackages().stream().map(PackageMapper::mapToEntity).collect(Collectors.toList()),//
                CourierMapper.mapToEntity(dto.getCourier())
        );
    }

    public static AppUser mapToEntity(AppUserAddDto dto) {
        return AppUser.of(//
                null,//
                dto.getCompany(),//
                dto.getFirstName(),//
                dto.getLastName(),//
                LocalDateTime.now(),//
                RoleMapper.mapToEntity(dto.getRole()),//
                null,//
                null
        );
    }
}
