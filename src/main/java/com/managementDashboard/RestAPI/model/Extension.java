package com.managementDashboard.RestAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.Sides;

@Getter
@Table(name = "extension")
@Entity
public class Extension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_extension")
    private Long id;

    @Column(name="tittle")
    private String tittle;

    @Column(name="content")
    private String content;

// foreign key asociada a task en uno a uno
    @Setter
    @OneToOne
    @JoinColumn(name = "task")
    @JsonIgnore
    private Task task;

    private Long id_task;


}
