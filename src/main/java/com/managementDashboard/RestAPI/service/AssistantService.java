package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.controller.dto.AssistantRequest;
import com.managementDashboard.RestAPI.controller.dto.AssistantResponse;
import com.managementDashboard.RestAPI.controller.dto.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class AssistantService {

    @Value("${deepseek.api.key}")
    private String apiKey;

    @Value("${deepseek.api.url}")
    private String apiUrl;

    @Value("${deepseek.api.model}")
    private String aiModel;

    private final RestTemplate restTemplate = new RestTemplate();

    public String askAssistant(String userPrompt){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

//        List<Message> messages = new ArrayList<>(Collections.singleton(new Message("user", userPrompt)));
        Message message = new Message("user", userPrompt);

        AssistantRequest assistantRequest = new AssistantRequest(
                aiModel,
                List.of(message),
                512
                );

        HttpEntity<AssistantRequest> request = new HttpEntity<>(assistantRequest, headers);

        ResponseEntity<AssistantResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                request,
                AssistantResponse.class
        );

        return Objects.requireNonNull(response
                        .getBody())
                .getChoices()
                .get(0)
                .message()
                .content();
    }

}
