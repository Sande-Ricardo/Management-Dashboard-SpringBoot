package com.managementDashboard.RestAPI.repository;

import com.managementDashboard.RestAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryI extends JpaRepository<User, Long> {
    public abstract User findByEmail(String email);

    Optional<User> findUserByUsername(String username);

//    @Query("SELECT u FROM User u WHERE u.username = ?")
//    Optional <User> findUser();
}




//public interface UserRepositoryI extends CrudRepository <User, Long>{
//
//    public abstract User findByEmail(String email);
//
//    public abstract Integer countById(Long id);
//
//
//}
