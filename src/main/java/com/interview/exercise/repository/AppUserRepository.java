package com.interview.exercise.repository;

import com.interview.exercise.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    List<AppUser> findAllByIdIn(List<Integer> ids);

    List<AppUser> findAllByLastNameIn(List<String> nazwiska);
}
