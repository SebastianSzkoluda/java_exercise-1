package com.interview.exercise.mapper;

import com.interview.exercise.dto.CourierDto;
import com.interview.exercise.entities.Courier;

import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourierMapper {

    public static CourierDto mapToDto(Courier entity) {
        return CourierDto.builder()//
                .id(entity.getId())//
                .firstName(entity.getFirstName())//
                .lastName(entity.getLastName())//
                .company(entity.getCompany())//
                .insertTime(entity.getInsertTime())//
                .client(AppUserMapper.mapToDto(entity.getClient()))//
                .packages(entity.getPackages().stream().map(PackageMapper::mapToDto).collect(Collectors.toList()))//
                .build();
    }

    public static Courier mapToEntity(CourierDto dto) {
        return Courier.of(//
                dto.getId(),//
                dto.getFirstName(),//
                dto.getLastName(),//
                dto.getCompany(),//
                dto.getInsertTime(),//
                AppUserMapper.mapToEntity(dto.getClient()),//
                dto.getPackages().stream().map(PackageMapper::mapToEntity).collect(Collectors.toList())//
        );
    }
}
