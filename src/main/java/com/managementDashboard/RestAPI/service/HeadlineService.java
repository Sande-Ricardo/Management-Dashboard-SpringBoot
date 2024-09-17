package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.controller.UserController;
import com.managementDashboard.RestAPI.model.Headline;
import com.managementDashboard.RestAPI.model.User;
import com.managementDashboard.RestAPI.repository.HeadlineRepositoryI;
import com.managementDashboard.RestAPI.repository.UserRepositoryI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class HeadlineService {

    @Autowired
    HeadlineRepositoryI headlineRepositoryI;
    @Autowired
    UserRepositoryI userRepositoryI;

    private final Logger logger = LoggerFactory.getLogger(HeadlineService.class);

//    public List<Headline> getAllHeadlinesById (Long id){
//        return (List<Headline>) headlineRepositoryI.findAllById_User(id);
//      }

//          CREATE

    public Headline setHeadline (Headline headline){
        try {
            headline.setUser(userRepositoryI.findById(headline.getId_user()).orElseThrow());
            headlineRepositoryI.save(headline);
            return headline;
        } catch (Exception Err){
            System.out.println("No se pudo establecer headline");
            return headline;
        }
    }


//          READ

    public ArrayList <Headline> getHeadline(){
    return (ArrayList<Headline>) headlineRepositoryI.findAll();
}

    public Headline getHeadlineById(Long id){
        return headlineRepositoryI.findById(id).orElse(null);
    }

    public boolean existHeadlineById (Long id){
        return headlineRepositoryI.existsById(id);
    }


//          UPDATE
    public Headline updateHeadlineId(Long id, Headline headline){
        if(this.existHeadlineById(id)){
            try {
                headlineRepositoryI.save(headline);
                return headline;
            } catch (Exception Err){
                System.out.println("Headline update error!");
                return null;
            }
        } else return null;
    }


//          DELETE

    public boolean deleteHeadlineById (Long id){
        try{
            headlineRepositoryI.deleteById(id);
            return true;
        } catch (Exception Err){
            return false;
        }
    }


}
