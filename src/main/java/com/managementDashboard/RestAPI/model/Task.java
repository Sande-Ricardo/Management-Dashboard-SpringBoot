package com.managementDashboard.RestAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;

    private String title;
    private String content;


//    //  foreign key asociada a headline en muchos a uno
//    @Setter
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "headline")
//    @JsonIgnore
//    private Headline headline;
//
////  columna no visible que asocia de uno a uno cada task con un extension
//    @OneToOne(mappedBy = "task")
//    private Extension extension;
//
//    private Long id_headline;


//    @ManyToOne
//    @JoinColumn(name = "id_headline")
//    private Headline id_headline;


}
