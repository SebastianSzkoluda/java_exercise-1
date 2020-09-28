package com.interview.exercise.mapper;

//Zakres szkolenia:

import com.interview.exercise.dto.UserDto;
import com.interview.exercise.entities.AppUser;

import java.time.LocalDateTime;

public interface AppUserMapper {

    AppUser userDtoToAppUser(UserDto userDto);

    default LocalDateTime modifyInsertName(UserDto userDto) {
        return LocalDateTime.now();
    }
}
