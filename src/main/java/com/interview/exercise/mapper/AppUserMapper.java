package com.interview.exercise.mapper;

import com.interview.exercise.dto.AppUserAddDto;
import com.interview.exercise.dto.AppUserDto;
import com.interview.exercise.entities.AppUser;
import com.interview.exercise.entities.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppUserMapper {

    public static AppUserDto mapToDto(AppUser entity) {
        return AppUserDto.builder()//
                .id(entity.getId())//
                .company(entity.getCompany())//
                .firstName(entity.getFirstName())//
                .lastName(entity.getLastName())//
                .insertTime(entity.getInsertTime())//
                .courier(Optional.ofNullable(entity.getCourier()).map(CourierMapper::mapToDto).orElse(null))//
                .packages(Optional.ofNullable(entity.getPackages())//
                        .map(pl -> pl.stream()//
                                .map(PackageMapper::mapToDto)//
                                .collect(Collectors.toList())//
                        ).orElse(Collections.emptyList())//
                )//
                .role(Optional.ofNullable(entity.getRole()).map(RoleMapper::mapToDto).orElse(null))//
                .build();
    }

    public static AppUser mapToEntity(AppUserDto dto) {
        return AppUser.of(//
                dto.getId(),//
                dto.getCompany(),//
                dto.getFirstName(),//
                dto.getLastName(),//
                dto.getInsertTime(),//
                Optional.ofNullable(dto.getRole()).map(RoleMapper::mapToEntity).orElse(null),//
                Optional.ofNullable(dto.getPackages())//
                        .map(pl -> pl.stream()//
                                .map(PackageMapper::mapToEntity)//
                                .collect(Collectors.toList())//
                        ).orElse(Collections.emptyList()),//
                Optional.ofNullable(dto.getCourier()).map(CourierMapper::mapToEntity).orElse(null)//
        );
    }

    public static AppUser mapToEntity(AppUserAddDto dto, Role role) {
        return AppUser.of(//
                null,//
                dto.getCompany(),//
                dto.getFirstName(),//
                dto.getLastName(),//
                LocalDateTime.now(),//
                role,//
                null,//
                null
        );
    }
}
