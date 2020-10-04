package com.interview.exercise.mapper;

import com.interview.exercise.dto.PackageAddDto;
import com.interview.exercise.dto.PackageDto;
import com.interview.exercise.entities.AppUser;
import com.interview.exercise.entities.Package;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PackageMapper {

    public static PackageDto mapToDto(Package entity) {
        return PackageDto.builder()//
                .id(entity.getId())//
                .packageStatus(entity.getStatus())//
                .build();
    }

    public static Package mapToEntity(PackageDto dto) {
        return Package.of(//
                dto.getId(),//
                dto.getPackageStatus(),//
                null,
                null
        );
    }

    public static Package mapToEntity(PackageAddDto dto, AppUser appUser) {
        return Package.of(//
                null,//
                dto.getPackageStatus(),//
                appUser,//
                null//
        );
    }
}
