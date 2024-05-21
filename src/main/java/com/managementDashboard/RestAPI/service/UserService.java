package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.model.User;
import com.managementDashboard.RestAPI.repository.UserRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

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

    public User getUserById(Long id ){
        return userRepositoryI.findById(id).orElse(null);
    }

}
