package com.interview.exercise.service.impl;

import com.interview.exercise.dto.PackageAddDto;
import com.interview.exercise.dto.PackageDto;
import com.interview.exercise.entities.Courier;
import com.interview.exercise.entities.Package;
import com.interview.exercise.entities.PackageStatus;
import com.interview.exercise.exception.AppUserNotFoundException;
import com.interview.exercise.exception.CourierNotFoundException;
import com.interview.exercise.exception.PackageAlreadyInCourierException;
import com.interview.exercise.exception.PackageNotFoundException;
import com.interview.exercise.mapper.PackageMapper;
import com.interview.exercise.repository.AppUserRepository;
import com.interview.exercise.repository.CourierRepository;
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
    private final CourierRepository courierRepository;

    @Autowired
    public PackageServiceImpl(PackageRepository packageRepository, AppUserRepository appUserRepository, CourierRepository courierRepository) {
        this.packageRepository = packageRepository;
        this.appUserRepository = appUserRepository;
        this.courierRepository = courierRepository;
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
                        "User with id: " + packageAddDto.getPackageUserToDeliveryFromId() + " not found"));
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
    public PackageDto addPackgeToCourier(Long packageId, Long courierId) {
        boolean isPackageInCourier = courierRepository.findAll().stream()//
                .anyMatch(c -> c.getPackages().stream().anyMatch(p -> p.getId().equals(packageId)));
        if (!isPackageInCourier) {
            Optional<Package> maybePackage = packageRepository.findById(packageId);
            Optional<Courier> maybeCourier = courierRepository.findById(courierId);
            Package aPackage = maybeCourier//
                    .map(c -> maybePackage//
                            .map(p -> p.withCourier(c).withStatus(PackageStatus.WENT_TO_COURIER))//
                            .orElseThrow(() -> new CourierNotFoundException("Package with id: " + packageId + " not found"))//
                    )//
                    .orElseThrow(() -> new PackageNotFoundException("Courier with id: " + courierId + " not found"));
            packageRepository.save(aPackage);
            return PackageMapper.mapToDto(aPackage);
        }
        throw new PackageAlreadyInCourierException("Package with id: " + packageId + " is already in courier");
    }
}
