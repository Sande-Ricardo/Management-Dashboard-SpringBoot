package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.model.User;
import com.managementDashboard.RestAPI.repository.UserRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepositoryI userRepositoryI;



//          CREATE

    public boolean setUser(User data) {
        try {
            userRepositoryI.save(data);
            return true;
        }catch (Exception Err){
            return false;
        }
    }


//          READ

    public ArrayList <User> getUser (){
        //try {
            return (ArrayList<User>) userRepositoryI.findAll();
        //}catch (Exception Err) {
        //    return null;
        //}
    }

    public boolean userExistById(Long id){
//        return userRepositoryI.findById(id).isPresent();

//        if(userRepositoryI.countById(id) == 1)
//            return true;
//        else return false;

//        logger.debug("Cantidad de usuarios obtenidos: {}", userRepositoryI.countById(id));

//        return userRepositoryI.countById(id) == 1;

        return userRepositoryI.existsById(id);
    }

    public ResponseEntity<User>  getUserById(Long id ){
        User user = userRepositoryI.findById(id).orElse(null);
        return ResponseEntity.ok(user);
    }

    public ArrayList<User> getUserByEmail(String email){
       return userRepositoryI.findByEmail(email);
    }


//          UPDATE

    public boolean userUpdate(User user){
        try {
            userRepositoryI.save(user);
            return true;
        } catch (Exception Err){
            return false;
        }
    }


//          DELETE
    public Boolean deleteUserById(Long id){
        try {
            userRepositoryI.deleteById(id);
            return true;
        } catch (Exception Err){
            return false;
        }
    }


//    public User getUserById(Long id ){
//        return userRepositoryI.findById(id).orElse(null);
//    }

//public ResponseEntity<User> getUserById(Long id){
//        try{
//            User user = userRepositoryI.findById(id).orElseThrow(()-> new ConfigDataResourceNotFoundException("usuario no encontrado"));
//            return ResponseEntity.ok(user);
//        } catch (ConfigDataResourceNotFoundException e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//}



}
