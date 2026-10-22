package com.dailycode.employee_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycode.employee_service.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

	List<Employee> findByDeptId(Long id);

}
