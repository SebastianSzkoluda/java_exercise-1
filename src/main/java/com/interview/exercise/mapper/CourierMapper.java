package com.interview.exercise.mapper;

import com.interview.exercise.dto.CourierAddDto;
import com.interview.exercise.dto.CourierDto;
import com.interview.exercise.entities.Courier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourierMapper {

    public static CourierDto mapToDto(Courier entity) {
        return CourierDto.builder()//
                .id(entity.getId())//
                .firstName(entity.getFirstName())//
                .lastName(entity.getLastName())//
                .company(entity.getCompany())//
                .insertTime(entity.getInsertTime())//
                .client(Optional.ofNullable(entity.getClient()).map(AppUserMapper::mapToDto).orElse(null))//
                .packages(Optional.ofNullable(entity.getPackages())//
                        .map(pl -> pl.stream()//
                                .map(PackageMapper::mapToDto)//
                                .collect(Collectors.toList())//
                        ).orElse(Collections.emptyList())//
                )//
                .build();
    }

    public static Courier mapToEntity(CourierDto dto) {
        return Courier.of(//
                dto.getId(),//
                dto.getFirstName(),//
                dto.getLastName(),//
                dto.getCompany(),//
                dto.getInsertTime(),//
                Optional.ofNullable(dto.getClient()).map(AppUserMapper::mapToEntity).orElse(null),//
                Optional.ofNullable(dto.getPackages())//
                        .map(pl -> pl.stream()//
                                .map(PackageMapper::mapToEntity)//
                                .collect(Collectors.toList())//
                        ).orElse(Collections.emptyList())//
        );
    }

    public static Courier mapToEntity(CourierAddDto dto) {
        return Courier.of(//
                null,//
                dto.getFirstName(),//
                dto.getLastName(),//
                dto.getCompany(),//
                LocalDateTime.now(),//
                null,//
                null//
        );
    }
}
