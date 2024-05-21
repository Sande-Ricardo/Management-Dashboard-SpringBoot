package com.managementDashboard.RestAPI.model;

import lombok.Getter;

import java.util.List;

@Getter
public class UserG {

    private final User user;
    private final List<Headline> headline;
    private List<Task> task;
    private List<Extension> extension;


    public UserG(User user, List<Headline> headline) {
        this.user = user;
        this.headline = headline;
//        this.task = task;
//        this.extension = extension;
    }
}
