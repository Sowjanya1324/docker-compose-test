package com.dailycode.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycode.employee_service.model.Employee;
import com.dailycode.employee_service.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/all")
	public List<Employee> getAll() {
		return empService.getAllEmployees();
	}
	
	@GetMapping("/{empid}")
	public Employee getById(@PathVariable("empid") Long id) {
		return empService.findEmpById(id);
		
	}
	@PostMapping("/add")
	public Employee saveEmp(@RequestBody Employee emp) {
			return empService.saveEmp(emp);
	 }
	@GetMapping("/department/{deptid}")
	public List<Employee> findByDeptId(@PathVariable("deptid") Long id) {
		System.out.println("inside deptid method");
		return empService.findByDeptId(id);
	}

}
