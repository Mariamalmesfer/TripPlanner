package com.example.tripplanner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "you should type something")
    private String message;

    @JsonIgnore
    private String respones;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore
    private User user;


    @ManyToOne
    @JoinColumn(name = "admin_id",referencedColumnName = "id")
    @JsonIgnore
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "plan_id",referencedColumnName = "id")
    @JsonIgnore
    private Plan plan;
}
