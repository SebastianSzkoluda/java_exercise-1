package com.interview.exercise.resource;

import com.interview.exercise.dto.PackageDto;
import com.interview.exercise.mapper.PackageMapper;
import com.interview.exercise.repository.PackageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/packages")
public class PackageController {

    private final PackageRepository packageRepository;

    @Autowired
    public PackageController(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @GetMapping("/all")
    public List<PackageDto> getAllPackagesInSystem() {
        return packageRepository.findAll().stream()//
                .map(PackageMapper::mapToDto)//
                .collect(Collectors.toList());
    }
}
