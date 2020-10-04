package com.interview.exercise.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@With
@Entity
@Table(name = "Courier")
public class Courier {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "company")
    private String company;
    @Column(name = "insert_time")
    private LocalDateTime insertTime;

    @OneToOne
    private AppUser client;

    @OneToMany(mappedBy = "courier", fetch = FetchType.EAGER)
    private List<Package> packages;
}
