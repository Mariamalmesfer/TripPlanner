package com.example.tripplanner.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username  is required")
    @Size(min=5,message = "The Username have to be more than 5 litters")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Password is required")
    @Size(min=6,message = "The password have to be more than 5 Char")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z]).{6,}$" , message = "the password must have at least 1 number, 1 letter (upper or lower case) and min 6 char")
    private String password;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "admin")
    private Set<Ticket> tickets;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "admin")
    private Set<Plan> plans;
}
