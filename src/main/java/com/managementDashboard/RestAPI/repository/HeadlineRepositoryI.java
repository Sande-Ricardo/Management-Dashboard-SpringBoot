package com.managementDashboard.RestAPI.repository;

import com.managementDashboard.RestAPI.model.Headline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//De momento no será utilizado
@Repository
public interface HeadlineRepositoryI extends JpaRepository<Headline, Long> {
}




//public interface HeadlineRepositoryI extends CrudRepository <Headline, Long>{
//
////    public abstract List<Headline> findAllById_User(Long id_user);
//
//}


