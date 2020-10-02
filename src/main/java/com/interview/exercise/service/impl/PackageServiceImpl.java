package com.interview.exercise.service.impl;

import com.interview.exercise.dto.PackageAddDto;
import com.interview.exercise.dto.PackageDto;
import com.interview.exercise.entities.Package;
import com.interview.exercise.exception.AppUserNotFoundException;
import com.interview.exercise.mapper.PackageMapper;
import com.interview.exercise.repository.AppUserRepository;
import com.interview.exercise.repository.PackageRepository;
import com.interview.exercise.service.PackageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    private final AppUserRepository appUserRepository;

    @Autowired
    public PackageServiceImpl(PackageRepository packageRepository, AppUserRepository appUserRepository) {
        this.packageRepository = packageRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public Optional<PackageDto> loadPackageById(Long id) {
        return packageRepository.findById(id)//
                .map(PackageMapper::mapToDto);
    }

    @Override
    public PackageDto addPackage(PackageAddDto packageAddDto) {
        Package aPackage = appUserRepository.findById(packageAddDto.getPackageUserToDeliveryFromId())//
                .map(u -> PackageMapper.mapToEntity(packageAddDto, u))//
                .orElseThrow(() -> new AppUserNotFoundException(
                        "User with id:" + packageAddDto.getPackageUserToDeliveryFromId() + " not found"));
        Package savedPackage = packageRepository.save(aPackage);
        return PackageMapper.mapToDto(savedPackage);
    }

    @Override
    public List<PackageDto> loadAllPackages() {
        return packageRepository.findAll().stream()//
                .map(PackageMapper::mapToDto)//
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PackageDto> addPackgeToCourier(Long packageId, Long courierId) {
        return Optional.empty();
    }
}
