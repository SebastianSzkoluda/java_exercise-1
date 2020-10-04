package com.interview.exercise.repository;

import com.interview.exercise.entities.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    List<Courier> findByIdIn(List<Long> ids);

    List<Courier> findByFirstNameAndLastName(String firstName, String lastName);
}
