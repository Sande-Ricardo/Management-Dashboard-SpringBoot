package com.managementDashboard.RestAPI.repository;

import com.managementDashboard.RestAPI.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositoryI extends CrudRepository <Task, Long> {
}
