package com.managementDashboard.RestAPI.repository;

import com.managementDashboard.RestAPI.model.Roles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepositoryI extends CrudRepository<Roles,Long> {

    List<Roles> findRolesByRoleEnumIn(List<String> roleNames);

}
