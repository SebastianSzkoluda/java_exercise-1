package com.interview.exercise.repository;

import com.interview.exercise.entities.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findByIdIn(List<Long> ids);

    List<AppUser> findByLastNameIn(List<String> lastNames);
}
