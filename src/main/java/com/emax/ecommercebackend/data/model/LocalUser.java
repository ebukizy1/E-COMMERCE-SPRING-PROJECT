package com.emax.ecommercebackend.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name= "Local user")
public class LocalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 255)
    private String username;

    @Column(name = "email", nullable = false, unique = true, length = 300)
    private String email;

    @Column(name = "password",nullable = false,length = 1000)
    private String password;


    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;


    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();


}
