package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.model.Headline;
import com.managementDashboard.RestAPI.model.User;
import com.managementDashboard.RestAPI.repository.HeadlineRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HeadlineService {

    @Autowired
    HeadlineRepositoryI headlineRepositoryI;

    public ArrayList <Headline> getHeadline(){
        return (ArrayList<Headline>) headlineRepositoryI.findAll();
    }

//    public List<Headline> getAllHeadlinesById (Long id){
//        return (List<Headline>) headlineRepositoryI.findAllById_User(id);
//    }

}
