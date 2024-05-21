package com.managementDashboard.RestAPI.repository;

import com.managementDashboard.RestAPI.model.Headline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeadlineRepositoryI extends CrudRepository <Headline, Long>{

//    public abstract List<Headline> findAllById_User(Long id_user);

}
