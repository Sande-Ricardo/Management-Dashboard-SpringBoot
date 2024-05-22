package com.managementDashboard.RestAPI.repository;

import com.managementDashboard.RestAPI.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepositoryI extends CrudRepository <User, Long>{

    public abstract ArrayList<User> findByEmail(String email);


}
