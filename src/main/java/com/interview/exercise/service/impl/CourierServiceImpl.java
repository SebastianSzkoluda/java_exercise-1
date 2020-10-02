package com.interview.exercise.service.impl;

import com.interview.exercise.dto.CourierAddDto;
import com.interview.exercise.dto.CourierDto;
import com.interview.exercise.entities.Courier;
import com.interview.exercise.mapper.CourierMapper;
import com.interview.exercise.repository.CourierRepository;
import com.interview.exercise.service.CourierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;

    @Autowired
    public CourierServiceImpl(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    @Override
    public Optional<CourierDto> loadCourierById(Long id) {
        return courierRepository.findById(id)//
                .map(CourierMapper::mapToDto);
    }

    @Override
    public CourierDto addCourier(CourierAddDto courierAddDto) {
        Courier courier = CourierMapper.mapToEntity(courierAddDto);
        Courier savedCourier = courierRepository.save(courier);
        return CourierMapper.mapToDto(savedCourier);
    }

    @Override
    public List<CourierDto> loadAllCouriers() {
        return courierRepository.findAll().stream()//
                .map(CourierMapper::mapToDto)//
                .collect(Collectors.toList());
    }

    @Override
    public List<CourierDto> loadAllCouriersWithPackages() {
        return loadAllCouriers().stream()//
                .filter(c -> !c.getPackages().isEmpty())//
                .collect(Collectors.toList());
    }

    @Override
    public List<CourierDto> loadAllCouriersWithFirstNameAndLastName(String firstName, String lastName) {
        return courierRepository.findByFirstNameAndLastName(firstName, lastName).stream()//
                .map(CourierMapper::mapToDto)//
                .collect(Collectors.toList());
    }
}
