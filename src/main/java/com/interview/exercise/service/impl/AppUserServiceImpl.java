package com.interview.exercise.service.impl;

import com.interview.exercise.dto.AppUserAddDto;
import com.interview.exercise.dto.AppUserDto;
import com.interview.exercise.entities.AppUser;
import com.interview.exercise.mapper.AppUserMapper;
import com.interview.exercise.repository.AppUserRepository;
import com.interview.exercise.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public Optional<AppUserDto> loadAppUserById(Long id) {
        return appUserRepository.findById(id)//
                .map(AppUserMapper::mapToDto);
    }

    @Override
    public AppUserDto addAppUser(AppUserAddDto appUserAddDto) {
        AppUser appUser = AppUserMapper.mapToEntity(appUserAddDto);
        AppUser savedAppUser = appUserRepository.save(appUser);
        return AppUserMapper.mapToDto(savedAppUser);
    }

    @Override
    public List<AppUserDto> loadAllAppUsers() {
        return appUserRepository.findAll().stream()//
                .map(AppUserMapper::mapToDto)//
                .collect(Collectors.toList());
    }
}
