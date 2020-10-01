package com.interview.exercise.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Courier {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String company;
    private LocalDateTime insertTime;

    @OneToOne
    private AppUser client;

    @OneToMany
    private List<Package> packages;
}