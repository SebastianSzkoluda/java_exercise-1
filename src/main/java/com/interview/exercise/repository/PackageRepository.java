package com.interview.exercise.repository;

import com.interview.exercise.entities.Package;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {

    List<Package> findByIdIn(List<Long> ids);
}
