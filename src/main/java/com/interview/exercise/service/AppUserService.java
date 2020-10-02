package com.interview.exercise.service;

import com.interview.exercise.dto.AppUserAddDto;
import com.interview.exercise.dto.AppUserDto;

import java.util.List;
import java.util.Optional;

public interface AppUserService {

    Optional<AppUserDto> loadAppUserById(Long id);

    AppUserDto addAppUser(AppUserAddDto appUserAddDto);

    List<AppUserDto> loadAllAppUsers();
}
