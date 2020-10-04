package com.interview.exercise.resource;

import com.interview.exercise.dto.PackageAddDto;
import com.interview.exercise.dto.PackageDto;
import com.interview.exercise.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {

    private final PackageService packageService;

    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageDto> getPackage(@PathVariable Long id) {
        return packageService.loadPackageById(id)//
                .map(ResponseEntity::ok)//
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<PackageDto> getAllPackages() {
        return packageService.loadAllPackages();
    }

    @PostMapping
    public ResponseEntity<PackageDto> addPackage(@RequestBody PackageAddDto packageAddDto) {
        PackageDto packageDto = packageService.addPackage(packageAddDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()//
                .path("/{id}").buildAndExpand(packageDto.getId())//
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{packageId}/{courierId}")
    public ResponseEntity<PackageDto> addPackageToCourier(@PathVariable Long packageId, @PathVariable Long courierId) {
        return ResponseEntity.ok(packageService.addPackgeToCourier(packageId, courierId));
    }
}
