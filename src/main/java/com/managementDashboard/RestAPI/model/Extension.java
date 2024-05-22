package com.managementDashboard.RestAPI.model;

import jakarta.persistence.*;
import lombok.Getter;

import javax.print.attribute.standard.Sides;

@Getter
@Table(name = "extension")
@Entity
public class Extension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_extension")
    private Integer id_extension;

    @Column(name="tittle")
    private String tittle;

    @Column(name="content")
    private String content;


//    @OneToOne
//    @JoinColumn(name = "id_task")
//    private Task id_task;


}
