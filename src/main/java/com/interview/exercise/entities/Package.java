package com.interview.exercise.entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@With
@Entity
@Table(name = "Package")
public class Package {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status")
    private PackageStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "package_user_to_deliver_from_id", referencedColumnName = "id")
    private AppUser packageUserToDeliveryFrom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;
}
