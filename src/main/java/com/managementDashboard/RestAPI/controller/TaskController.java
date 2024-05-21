package com.managementDashboard.RestAPI.controller;

import com.managementDashboard.RestAPI.model.Task;
import com.managementDashboard.RestAPI.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;

    @GetMapping("/get")
    public ArrayList<Task> getTask (){
        return  taskService.getTask();
    }

}
