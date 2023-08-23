package com.example.tripplanner.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String destination;
    private String duration;
    private String category;
    private String hotel;
    private String flightTicket;
    private Double totalPrice;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aPackage")
    private Set<Plan> plans;


    @ManyToMany(mappedBy = "packageSet")
    private  Set<User> users;


}
