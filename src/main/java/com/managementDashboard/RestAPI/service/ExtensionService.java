package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.model.Extension;
import com.managementDashboard.RestAPI.model.Task;
import com.managementDashboard.RestAPI.repository.ExtensionRepositoryI;
import com.managementDashboard.RestAPI.repository.TaskRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtensionService {

    @Autowired
    ExtensionRepositoryI extensionRepositoryI;
//    @Autowired
//    TaskRepositoryI taskRepositoryI;
//    public Extension setExtension (Extension extension){
//        try {
//            extension.setTask(taskRepositoryI.findById(extension.getId_task()).orElseThrow());
//            extensionRepositoryI.save(extension);
//            return extension;
//        } catch (Exception Err){
//            return null;
//        }
//    }

}
