package com.managementDashboard.RestAPI.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter
@Table(name="user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

//  columna no visible que asocia de uno a muchos cada usuario con sus respectivos registros de headline
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL
//            , fetch = FetchType.LAZY
    )
    @Column(name="headlines")
    private Set<Headline> headlines;


}

