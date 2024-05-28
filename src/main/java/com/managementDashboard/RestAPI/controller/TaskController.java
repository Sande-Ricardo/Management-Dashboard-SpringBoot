package com.managementDashboard.RestAPI.controller;

import com.managementDashboard.RestAPI.model.Headline;
import com.managementDashboard.RestAPI.model.Task;
import com.managementDashboard.RestAPI.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;

//          CREATE

    @PostMapping("/set")
    public Task setTask (@RequestBody Task task){
        return taskService.setTask(task);
    }


//          READ

    @GetMapping("/get")
    public Set<Task> getTask (){
        return taskService.getTask();
    }

    @GetMapping("/get/{id}")
    public Task getTaskById (@PathVariable Long id){
        return taskService.getTaskById(id);
    }


//          UPDATE

    @PostMapping("/update/{id}")
    public Task updateTaskById(@RequestBody Task task, @PathVariable Long id){
        return taskService.updateTaskById(id, task);
    }


//          DELETE

    @DeleteMapping("/del/{id}")
    public boolean deleteTaskById(@PathVariable Long id){
        return taskService.deleteTaskById(id);
    }

}
