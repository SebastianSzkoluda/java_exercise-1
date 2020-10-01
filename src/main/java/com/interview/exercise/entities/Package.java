package com.interview.exercise.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Package {

    @Id
    @GeneratedValue
    private Long id;
    private PackageStatus status;

    @JsonBackReference
    @ManyToOne
    private AppUser packageUserToDeliveryFrom;

    @JsonBackReference
    @ManyToOne
    private Courier courier;
}
