package com.example.tripplanner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RatingAndReview {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    private Integer rating;
    private String review;


    @ManyToOne
    @JoinColumn(name = "package_id",referencedColumnName = "id")
    @JsonIgnore
    private Package aPackage;

}






