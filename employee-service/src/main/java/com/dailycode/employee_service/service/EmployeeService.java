package com.dailycode.employee_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.dailycode.employee_service.dao.EmployeeDao;
import com.dailycode.employee_service.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private KafkaTemplate<Long, Employee> kafkaTemplate;
	
	@Autowired
	private EmployeeDao empDao;

	public List<Employee> getAllEmployees() {
		return empDao.findAll();
	}

	public Employee findEmpById(Long id) {
		return empDao.findById(id).orElse(null);
	}

	public Employee saveEmp(Employee emp) {
		Employee saveEmp=empDao.save(emp);
		kafkaTemplate.send("employee-topic", saveEmp.getId(), saveEmp);
		return saveEmp;
	}

	public List<Employee> findByDeptId(Long id) {
		// TODO Auto-generated method stub
		return empDao.findByDeptId(id);
	}

}
