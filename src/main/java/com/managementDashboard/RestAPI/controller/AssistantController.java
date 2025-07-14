package com.managementDashboard.RestAPI.controller;

import com.managementDashboard.RestAPI.service.AssistantService;
import com.managementDashboard.RestAPI.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//@PreAuthorize("permitAll()")
@RequestMapping("/ai")
public class AssistantController {


    @Autowired
    private AssistantService assistantService;

    @PreAuthorize("permitAll")
    @PostMapping("/ask")
    public ResponseEntity<String> askAssistant(@RequestBody Map<String, String> payload){
//        return new ResponseEntity<>(assistantService.askAssistant(userPrompt),HttpStatus.OK);

        String prompt = payload.get("prompt");
        String response = assistantService.askAssistant(prompt);

        return ResponseEntity.ok(response);
    }


    @PreAuthorize("permitAll")
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        String response = assistantService.askAssistant("¿Cuál es el mejor día del año?");

        return ResponseEntity.ok(response);
    }
}
