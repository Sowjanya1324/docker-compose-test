package com.dailycode.department_service.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dailycode.department_service.controller.dto.Employee;
import com.dailycode.department_service.controller.model.Department;
import com.dailycode.department_service.repository.DepartmentDao;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao deptDao;
	
	@Autowired
	private WebClient empClient;
	
	public List<Department> getAllDepts() {
		return deptDao.findAll();
	}

	public Department findDeptById(Long id) {
		// TODO Auto-generated method stub
		return deptDao.findById(id).orElse(null);
	}

	public Department addDepart(Department dept) {
		return deptDao.save(dept);
	}

	public List<Department> getAllDeptsWithEmps() {
		List<Department> allDepts = getAllDepts();
		for(Department dept:allDepts) {
			Employee[] empArr = empClient.get().uri("/department/{deptid}", dept.getId())
			.retrieve()
			.bodyToMono(Employee[].class)
			.block();
			dept.setEmployees(Arrays.asList(empArr));
		}
		
		return allDepts;
	}

}
