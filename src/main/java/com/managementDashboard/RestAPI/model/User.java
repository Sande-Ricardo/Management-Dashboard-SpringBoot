package com.managementDashboard.RestAPI.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//@Data
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String name;

    private String last_name;

    @Column(unique = true)
    private String username;

    private String email;

    private String password;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Headline> headlines = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<FlashCard> flashCards = new ArrayList<>();


//    Spring Security specific
    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "account_no_expired")
    private boolean accountNoExpired;

    @Column(name = "account_no_locked")
    private boolean accountNoLocked;

    @Column(name = "credential_no_expired")
    private boolean credentialNoExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();


////  columna no visible que asocia de uno a muchos cada usuario con sus respectivos registros de headline
//    @OneToMany(mappedBy = "user",
//            cascade = CascadeType.ALL
//    )
////    @Column(name="headlines")
//    private Set<Headline> headlines;


}

