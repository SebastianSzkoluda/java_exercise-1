package com.interview.exercise.resource;

import com.interview.exercise.dto.UserDto;
import com.interview.exercise.entities.AppUser;
import com.interview.exercise.entities.Package;
import com.interview.exercise.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paczki")
public class GiveMeAllPackagesFacade {

    @Autowired
    AppUserRepository appUserRepository;


    @GetMapping("/all")
    public List<Package> getAllPackagesInSystem(List<UserDto> użytkownicy) {

        int helper = 0;

        List<AppUser> wszyscy = new ArrayList<AppUser>();
        List<String> userSurnames = new ArrayList<>();
        for (UserDto myUser : użytkownicy) {

            System.out.println(myUser.getName());

            userSurnames.add(użytkownicy.get(helper).getSurname());

            helper++;


            wszyscy = appUserRepository.findAllByLastNameIn(userSurnames);
        }

        List<Package> paczki = new ArrayList<>();

        for (AppUser user : wszyscy) {
            List<Package> aPackage = user.getAPackage();
            paczki.addAll(aPackage);
        }


        return paczki;


    }

}
