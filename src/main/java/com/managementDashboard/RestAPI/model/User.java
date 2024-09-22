package com.managementDashboard.RestAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String name;
    private String last_name;
    private String username;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Headline> headlines = new ArrayList<>();




////  columna no visible que asocia de uno a muchos cada usuario con sus respectivos registros de headline
//    @OneToMany(mappedBy = "user",
//            cascade = CascadeType.ALL
//    )
////    @Column(name="headlines")
//    private Set<Headline> headlines;


}

