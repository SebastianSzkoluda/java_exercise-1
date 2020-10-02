package com.interview.exercise.service;

import com.interview.exercise.dto.CourierAddDto;
import com.interview.exercise.dto.CourierDto;

import java.util.List;
import java.util.Optional;

public interface CourierService {

    Optional<CourierDto> loadCourierById(Long id);

    CourierDto addCourier(CourierAddDto courierAddDto);

    List<CourierDto> loadAllCouriers();

    List<CourierDto> loadAllCouriersWithPackages();

    List<CourierDto> loadAllCouriersWithFirstNameAndLastName(String firstName, String lastName);
}
