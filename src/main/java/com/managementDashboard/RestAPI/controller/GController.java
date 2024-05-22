package com.managementDashboard.RestAPI.controller;

import com.managementDashboard.RestAPI.model.*;
import com.managementDashboard.RestAPI.service.ExtensionService;
import com.managementDashboard.RestAPI.service.HeadlineService;
import com.managementDashboard.RestAPI.service.TaskService;
import com.managementDashboard.RestAPI.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/allmight")
public class GController {

    private final Logger logger = LoggerFactory.getLogger(GController.class);


    @Autowired
    UserService userService;
    @Autowired
    HeadlineService headlineService;
    @Autowired
    TaskService taskService;
    @Autowired
    ExtensionService extensionService;


    public UserData user;

    @GetMapping("/get/{id}")
    public Optional<UserG> getData (@PathVariable("id") Long id){

        ResponseEntity<User> user = userService.getUserById(id);
//        List<Headline> headlines = headlineService.getAllHeadlinesById(id);

//        UserG userg = new UserG(user, headlines);
//        return userg;
        return null;
    }

    @GetMapping("/users")
    public UserData users(){
        return user;
    }

}
