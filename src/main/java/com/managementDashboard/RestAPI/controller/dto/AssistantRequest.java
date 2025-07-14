package com.managementDashboard.RestAPI.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssistantRequest {

    private String model;
    private List<Message> messages;
    private int max_tokens;

}
