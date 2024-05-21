package com.managementDashboard.RestAPI.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table (name="headline")
public class Headline {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_headline")
    private Integer id_headline;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="id_user")
//    private User user;

//    @ManyToOne
//    @JoinColumn(name = "id_task")
//    private Task id_task;

}
