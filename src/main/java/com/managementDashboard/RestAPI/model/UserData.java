package com.managementDashboard.RestAPI.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {

    private User user;
    private Headline headline;
    private Task task;
    private Extension extension;

}
