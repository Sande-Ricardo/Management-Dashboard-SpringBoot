package com.managementDashboard.RestAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FlashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFlashCard;

    private String title;

    private String content;
}
