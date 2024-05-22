package com.managementDashboard.RestAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table (name="headline")
public class Headline {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="id_user")
//    private User user;

//    @ManyToOne
//    @JoinColumn(name = "id_task")
//    private Task id_task;

}
