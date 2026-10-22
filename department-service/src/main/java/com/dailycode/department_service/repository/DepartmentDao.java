package com.dailycode.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycode.department_service.controller.model.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long>{

}
