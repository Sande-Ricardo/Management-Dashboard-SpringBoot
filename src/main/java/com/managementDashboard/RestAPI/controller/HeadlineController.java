package com.managementDashboard.RestAPI.controller;

import com.managementDashboard.RestAPI.model.Headline;
import com.managementDashboard.RestAPI.service.HeadlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/headline")
public class HeadlineController {

    private final Logger logger = LoggerFactory.getLogger(HeadlineController.class);

    @Autowired
    HeadlineService headlineService;

    @GetMapping("/get")
    public ArrayList <Headline> getHeadline (){
        return headlineService.getHeadline();
    }

}
