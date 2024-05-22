package com.managementDashboard.RestAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table (name="headline")
public class Headline {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="content")
    private String content;

//  foreign key asociada a user en muchos a uno (muchos registros para un user)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

//  columna no visible que asocia de uno a muchos cada headline con sus respectivos registros de task
    @OneToMany(mappedBy = "headline", cascade = CascadeType.ALL)
    @Column(name="tasks")
    private Set<Task> tasks;

}
