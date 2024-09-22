package com.managementDashboard.RestAPI.repository;

import com.managementDashboard.RestAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryI extends JpaRepository<User, Long> {
    public abstract User findByEmail(String email);
}




//public interface UserRepositoryI extends CrudRepository <User, Long>{
//
//    public abstract User findByEmail(String email);
//
//    public abstract Integer countById(Long id);
//
//
//}
