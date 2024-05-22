package com.managementDashboard.RestAPI.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name= "task")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_task")
    private Integer id_task;

    @Column(name="content")
    private String content;


//    @ManyToOne
//    @JoinColumn(name = "id_headline")
//    private Headline id_headline;
}
