package com.managementDashboard.RestAPI.controller;

import com.managementDashboard.RestAPI.model.User;
import com.managementDashboard.RestAPI.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;


//          CREATE

    @PostMapping("/set")
    public ResponseEntity<User> setUser(@RequestBody User user){

        logger.debug("userController");
        return userService.setUser(user);

    }

//    @PostMapping("/set_headline")
//    public User setHeadline(@RequestBody Headline headline) {
//        return userService.setHeadline(headline);
//    }


//          READ

    @GetMapping("/get")
    public List<User> getUsers() {return userService.getUsers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/get/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<User> loginUser(@PathVariable String email, @PathVariable String password){
        logger.debug("loginUser");
        return userService.loginUser(email, password);
    }


//          UPDATE

//  Revisar si es necesario el if, en lugar de la implementación en solitario
    @PostMapping("/update/{id}")
    public ResponseEntity<User> updateById(@RequestBody User user, @PathVariable Long id){
        return userService.updateUserById(id, user);
    }


//          DELETE

    @DeleteMapping("/del/{id}")
    public boolean deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);
    }


}