package com.managementDashboard.RestAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Table(name= "task")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_task")
    private Long id;

    @Column(name="content")
    private String content;

//  foreign key asociada a headline en muchos a uno
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_headline")
    @JsonIgnore
    private Headline headline;

//  columna no visible que asocia de uno a uno cada task con un extension
    @OneToOne(mappedBy = "task")
    private Extension extension;



//    @ManyToOne
//    @JoinColumn(name = "id_headline")
//    private Headline id_headline;
}
