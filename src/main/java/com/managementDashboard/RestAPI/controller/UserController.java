package com.managementDashboard.RestAPI.controller;

import com.managementDashboard.RestAPI.model.Headline;
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
    public ResponseEntity<User> setUser(@RequestBody User user) {
        return userService.setUser(user);
    }

//    @PostMapping("/set_headline")
//    public User setHeadline(@RequestBody Headline headline) {
//        return userService.setHeadline(headline);
//    }


//          READ

    @GetMapping("/get")
    public ArrayList<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

//  Sirve??
    @GetMapping("/get/exist/{id}")
    public boolean userExistById (@PathVariable Long id){
        return userService.userExistById(id);
    }

    @GetMapping("/get/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }


//          UPDATE

//  Revisar si es necesario el if, en lugar de la implementación en solitario
    @PostMapping("/update/{id}")
    public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }


//          DELETE

    @DeleteMapping("/del/{id}")
    public boolean deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);
    }


}