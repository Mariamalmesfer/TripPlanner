package com.example.tripplanner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Destination is required")
    private String destination;


    @NotNull(message = "Destination is required")
    @Pattern(regexp =".*days$" , message = "please enter the duration in num and days to it ")
    private String duration;

    @NotNull(message = "Category is required")
    private String category;

    @NotNull(message = "Hotel is required")
    private String hotel;

    @NotNull(message = "Hotel stars is required")
    @Max(value = 5 , message = "max stars is 5")
    @Min(value = 2,message = "min stars is 2" )
    private Integer hotelStars;

    @NotNull(message = "Flight Ticket is required")
    @Pattern(regexp = "^(first class|economy|business)$" , message = "must be for  buy or rent")
    private String flightTicket;

    @NotNull(message = "Total Price is required")
    private Double totalPrice;


    @NotNull(message = "persons Price is required")
    @Min(value = 2,message = "at lest tow persons")
    private Integer numpersons;


    private Integer PackageRate=0;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aPackage")
    private Set<Plan> plans;


    @OneToMany(mappedBy = "aPackage")
    private Set<RatingAndReview> ratingAndReviews;




}
