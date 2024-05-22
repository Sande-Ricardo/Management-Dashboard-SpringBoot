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


//          CREATE

    @PostMapping("/set")
    public boolean setUserById(@RequestBody User user) {
        return userService.setUser(user);
    }


//          READ

    @GetMapping("/get")
    public ArrayList<User> ex() {
        return userService.getUser();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        ResponseEntity<User> user = userService.getUserById(id);
        return user;
    }

    @GetMapping("/get/email/{email}")
    public ArrayList<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }


//          UPDATE


//          DELETE

    @DeleteMapping("/del/{id}")
    public boolean deleteUserById(@PathVariable Long id){
        try{
            userService.deleteUserById(id);
            return true;
        } catch (Exception Err){
            return false;
        }
    }


}