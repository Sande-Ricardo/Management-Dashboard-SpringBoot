package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.model.Headline;
import com.managementDashboard.RestAPI.model.Task;
import com.managementDashboard.RestAPI.repository.HeadlineRepositoryI;
import com.managementDashboard.RestAPI.repository.TaskRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class TaskService {

    @Autowired
    TaskRepositoryI taskRepositoryI;
    @Autowired
    HeadlineRepositoryI headlineRepositoryI;


//          CREATE

    public Task setTask (Task task){
        try {
            task.setHeadline(headlineRepositoryI.findById(task.getId_headline()).orElseThrow());
            taskRepositoryI.save(task);
            return task;
        } catch (Exception Err){
            return null;
        }
    }


//          READ

    public Set<Task> getTask(){
        return(Set<Task>) taskRepositoryI.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepositoryI.findById(id).orElseThrow();
    }

    public boolean existTaskById (Long id){
        return taskRepositoryI.existsById(id);
    }


//          UPDATE

    public Task updateTaskById(Long id, Task task){
        if(this.existTaskById(id)){
            try{
                taskRepositoryI.save(task);
                return task;
            } catch (Exception Err){
                return null;
            }
        } else return null;
    }


//          DELETE

    public boolean deleteTaskById (Long id) {
        try {
            taskRepositoryI.deleteById(id);
            return true;
        } catch(Exception Err){
            return false;
        }
    }

}
