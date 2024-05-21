package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.repository.ExtensionRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtensionService {

    @Autowired
    ExtensionRepositoryI extensionRepositoryI;



}
