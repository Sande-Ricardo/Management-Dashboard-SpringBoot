package com.managementDashboard.RestAPI.controller;

import com.managementDashboard.RestAPI.model.Headline;
import com.managementDashboard.RestAPI.service.HeadlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/headline")
public class HeadlineController {

    private final Logger logger = LoggerFactory.getLogger(HeadlineController.class);

    @Autowired
    HeadlineService headlineService;


//          CREATE

    @PostMapping("/set")
    public Headline setHeadline (@RequestBody Headline headline){
        return headlineService.setHeadline(headline);
    }


//          READ

    @GetMapping("/get")
    public ArrayList <Headline> getHeadline (){
        return headlineService.getHeadline();
    }

    @GetMapping("/get/{id}")
    public Headline getHeadlineById (@PathVariable Long id){
        return headlineService.getHeadlineById(id);
    }


//          UPDATE

    @PostMapping("/update/{id}")
    public Headline updateHeadlineById(@RequestBody Headline headline, @PathVariable Long id){
        return headlineService.updateHeadlineId(id, headline);
    }


//          DELETE

    @DeleteMapping("/del/{id}")
    public boolean deleteHeadlineById(@PathVariable Long id){
        return headlineService.deleteHeadlineById(id);
    }
}
