package com.interview.exercise.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private String roleType;

    @OneToMany
    private List<AppUser> users;


}
