package com.managementDashboard.RestAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Headline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHeadline;

    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();



////  foreign key asociada a user en muchos a uno (muchos registros para un user)
//    @Setter
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user")
//    @JsonIgnore
//    private User user;
//
////  columna no visible que asocia de uno a muchos cada headline con sus respectivos registros de task
//    @OneToMany(mappedBy = "headline", cascade = CascadeType.ALL)
//    @Column(name="tasks")
//    private Set<Task> tasks;
//
//    private Long id_user;


}
