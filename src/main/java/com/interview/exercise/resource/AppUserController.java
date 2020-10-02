package com.interview.exercise.resource;

import com.interview.exercise.dto.AppUserAddDto;
import com.interview.exercise.dto.AppUserDto;
import com.interview.exercise.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDto> getUser(@PathVariable Long id) {
        return appUserService.loadAppUserById(id)//
                .map(ResponseEntity::ok)//
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<AppUserDto> getAllAppUsers() {
        return appUserService.loadAllAppUsers();
    }

    @PostMapping
    public ResponseEntity<AppUserDto> addAppUser(@RequestBody AppUserAddDto appUserAddDto) {
        AppUserDto appUserDto = appUserService.addAppUser(appUserAddDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()//
                .path("/{id}").buildAndExpand(appUserDto.getId())//
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
