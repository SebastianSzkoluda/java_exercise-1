package com.interview.exercise.service;

import com.interview.exercise.dto.PackageAddDto;
import com.interview.exercise.dto.PackageDto;

import java.util.List;
import java.util.Optional;

public interface PackageService {

    Optional<PackageDto> loadPackageById(Long id);

    PackageDto addPackage(PackageAddDto packageAddDto);

    List<PackageDto> loadAllPackages();

    PackageDto addPackgeToCourier(Long packageId, Long courierId);
}
