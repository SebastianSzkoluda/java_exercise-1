package com.interview.exercise.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Double id;
    private String name;
    private String lastName;
    private String roleType;
    private String upperName;

    @JsonBackReference
    @OneToOne
    private AppUser user;


}
