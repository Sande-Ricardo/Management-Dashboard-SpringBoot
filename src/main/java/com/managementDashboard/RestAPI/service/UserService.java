package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.controller.UserController;
import com.managementDashboard.RestAPI.model.User;
import com.managementDashboard.RestAPI.repository.UserRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResource;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepositoryI userRepositoryI;

    public ArrayList <User> getUser (){
        //try {
            return (ArrayList<User>) userRepositoryI.findAll();
        //}catch (Exception Err) {
        //    return null;
        //}
    }


    public boolean setUser(User data) {
        try {
            userRepositoryI.save(data);
            return true;
        }catch (Exception Err){
            return false;
        }
    }

//    public User getUserById(Long id ){
//        return userRepositoryI.findById(id).orElse(null);
//    }
    public ResponseEntity<User>  getUserById(Long id ){
        User user = userRepositoryI.findById(id).orElse(null);
        return ResponseEntity.ok(user);
    }


//public ResponseEntity<User> getUserById(Long id){
//        try{
//            User user = userRepositoryI.findById(id).orElseThrow(()-> new ConfigDataResourceNotFoundException("usuario no encontrado"));
//            return ResponseEntity.ok(user);
//        } catch (ConfigDataResourceNotFoundException e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//}



}
