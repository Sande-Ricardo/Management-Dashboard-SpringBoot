package com.managementDashboard.RestAPI.controller;

import com.managementDashboard.RestAPI.model.User;
import com.managementDashboard.RestAPI.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public ArrayList<User> ex(){
        return userService.getUser();
    }

    @PostMapping("/set")
    public boolean ex(@RequestBody User user){
        return userService.setUser(user);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User data = userService.getUserById(id);
        return new ResponseEntity<User>(data, HttpStatus.OK);
    }

}
