package com.managementDashboard.RestAPI.controller.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.managementDashboard.RestAPI.model.FlashCard;
import com.managementDashboard.RestAPI.model.Headline;

import java.util.List;

@JsonPropertyOrder({"username", "message", "jwt", "id", "name", "last_name", "email", "headlines", "flashCards" , "status"})
public record AuthResponse(String username,
                           String message,
                           String jwt,

                           Long id,
                           String name,
                           String last_name,
                           String email,
                           List<Headline> headlines,
                           List<FlashCard> flashCards,

                           boolean status) {



}
