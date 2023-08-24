package com.example.tripplanner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    private String destination;


    //@Pattern(regexp ="^[0-9]+days$" , message = "please enter the duration in num and days to it ")
    private String duration;

    private String category;

    private String hotel;

    private Integer hotelStars;

    //@Pattern(regexp = "^(Buy|economy|business)$" , message = "must be for  buy or rent")
    private String flightTicket;


    private Double totalPrice;


    private Integer numpersons;
    private String status;


    @ManyToOne
    @JoinColumn(name = "package_id",referencedColumnName = "id")
    @JsonIgnore
    private Package aPackage;


    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "admin_id",referencedColumnName = "id")
    @JsonIgnore
    private Admin admin;


    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "plan")
    private Set<Ticket> tickets;



}