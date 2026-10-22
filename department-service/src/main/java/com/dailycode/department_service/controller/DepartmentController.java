package com.dailycode.department_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycode.department_service.controller.model.Department;
import com.dailycode.department_service.service.DepartmentService;

@RestController
@RequestMapping("/api/depart")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/all")
	public List<Department> getAllDept() {
		return deptService.getAllDepts();
	}
	
	@GetMapping("/{id}")
	public Department getDeptById(@PathVariable Long id) {
		return deptService.findDeptById(id);
		
	}
	
	@PostMapping("/add")
	public Department saveDept(@RequestBody Department dept) {
		return deptService.addDepart(dept);
	}
	
	@GetMapping("/all/withemp")
	public List<Department> getDeptWithEmp(){
		return deptService.getAllDeptsWithEmps();
		
	}

}
