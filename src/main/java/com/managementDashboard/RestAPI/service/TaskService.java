package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.model.Task;
import com.managementDashboard.RestAPI.repository.TaskRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {

    @Autowired
    TaskRepositoryI taskRepositoryI;

    public ArrayList <Task> getTask(){
        return(ArrayList<Task>) taskRepositoryI.findAll();
    }

}
