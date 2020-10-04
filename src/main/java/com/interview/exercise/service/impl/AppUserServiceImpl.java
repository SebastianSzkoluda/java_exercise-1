package com.interview.exercise.service.impl;

import com.interview.exercise.dto.AppUserAddDto;
import com.interview.exercise.dto.AppUserDto;
import com.interview.exercise.entities.AppUser;
import com.interview.exercise.exception.RoleNotFoundException;
import com.interview.exercise.mapper.AppUserMapper;
import com.interview.exercise.repository.AppUserRepository;
import com.interview.exercise.repository.RoleRepository;
import com.interview.exercise.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, RoleRepository roleRepository) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<AppUserDto> loadAppUserById(Long id) {
        return appUserRepository.findById(id)//
                .map(AppUserMapper::mapToDto);
    }

    @Override
    public AppUserDto addAppUser(AppUserAddDto appUserAddDto) {
        AppUser appUser = roleRepository.findById(appUserAddDto.getRoleId())//
                .map(r -> AppUserMapper.mapToEntity(appUserAddDto, r))//
                .orElseThrow(() -> new RoleNotFoundException("Role with id: " + appUserAddDto.getRoleId() + " not found"));
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
