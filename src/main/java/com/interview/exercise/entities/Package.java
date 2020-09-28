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
public class Package {

    @Id
    @GeneratedValue
    private int id;

    @JsonBackReference
    @OneToOne
    private AppUser packageUserToDeliveryFrom;

}
