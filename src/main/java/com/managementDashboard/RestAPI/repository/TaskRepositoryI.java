package com.managementDashboard.RestAPI.repository;

import com.managementDashboard.RestAPI.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//De momento no será utilizado
@Repository
public interface TaskRepositoryI extends JpaRepository<Task, Long> {
}




//public interface TaskRepositoryI extends CrudRepository <Task, Long> {
//}
