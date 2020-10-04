package com.interview.exercise.resource;

import com.interview.exercise.dto.CourierAddDto;
import com.interview.exercise.dto.CourierDto;
import com.interview.exercise.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/couriers")
public class CourierController {

    private final CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourierDto> getCourier(@PathVariable Long id) {
        return courierService.loadCourierById(id)//
                .map(ResponseEntity::ok)//
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<CourierDto> getAllCouriers() {
        return courierService.loadAllCouriers();
    }

    @GetMapping("/with-package")
    public List<CourierDto> getAllCouriersWithPackages() {
        return courierService.loadAllCouriersWithPackages();
    }

    @GetMapping("/all-by-names")
    public List<CourierDto> getAllCouriersByFirstNameAndLastName(@RequestParam String firstName,
            @RequestParam String lastName) {
        return courierService.loadAllCouriersWithFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping
    public ResponseEntity<CourierDto> addCourier(@RequestBody CourierAddDto courierAddDto) {
        CourierDto courierDto = courierService.addCourier(courierAddDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()//
                .path("/{id}").buildAndExpand(courierDto.getId())//
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
