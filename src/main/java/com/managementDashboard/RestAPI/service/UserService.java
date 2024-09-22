package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.model.User;
import com.managementDashboard.RestAPI.repository.UserRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepositoryI userRepositoryI;



//          CREATE

//  Un registro por email
    public ResponseEntity<User> setUser(User user) {
        if (userRepositoryI.findByEmail(user.getEmail()) != null) {
            logger.error("Email ingresado se encuentra registrado.");
            return ResponseEntity.notFound().build();
        } else {
            try {
                userRepositoryI.save(user);
                return ResponseEntity.ok(user);
            }catch (Exception Err){
                logger.error("Formato inválido");
                return ResponseEntity.notFound().build();

            }
        }
    }



//          READ

    public List<User> getUsers(){
        return userRepositoryI.findAll();
    }

    public ResponseEntity<User>  getUserById(Long id ){
        User user = userRepositoryI.findById(id).orElse(null);
        return ResponseEntity.ok(user);
    }

    public boolean userExistById(Long id){
        return userRepositoryI.existsById(id);
    }

    public User getUserByEmail(String email){
       return userRepositoryI.findByEmail(email);
    }

    public ResponseEntity<User> loginUser (String email, String password){

        try{
            User user = userRepositoryI.findByEmail(email);
            if(!user.getPassword().equals(password)){
                logger.debug("Contraseña '" + password + "' incorrecta!!");
                return null;
            } else {
                logger.debug("Login existoso");
                return ResponseEntity.ok(user);
            }
        }catch (Exception error){
            logger.debug("Email o contraseña incorrecta: " + email + " " + password);
            return null;
        }
    }

//          UPDATE

    public ResponseEntity<User> updateUserById(Long id, User user){
        if(this.userExistById(id)){
            try {
                userRepositoryI.save(user);
                logger.debug("Update user");
                return ResponseEntity.ok(user);
            } catch (Exception Err){
                System.out.println("Update error!!");
                System.out.println(user);
                System.out.println(id);
                return null;
            }
        } else return null;
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





}
