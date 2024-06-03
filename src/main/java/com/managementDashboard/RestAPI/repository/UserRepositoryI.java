package com.managementDashboard.RestAPI.repository;

import com.managementDashboard.RestAPI.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepositoryI extends CrudRepository <User, Long>{

    public abstract User findByEmail(String email);

    public abstract Integer countById(Long id);


}
