package com.managementDashboard.RestAPI.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Table(name="user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Integer id_user;

    @Column(name="name")
    private String name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;


//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Headline> headline;

//    @OneToMany
//    @JoinColumn(name = "headline")
//    private ArrayList<Headline> headline;

}

