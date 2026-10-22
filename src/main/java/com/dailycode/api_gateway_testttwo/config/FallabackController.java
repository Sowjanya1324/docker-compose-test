package com.dailycode.api_gateway_testttwo.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallabackController {
	
	@GetMapping("/fallback/department")
	public String fallback() {
		return "Department Service has issue.please try again...";
		
	}
	
	@GetMapping("/fallback/employee")
	public String fallbackEmployee() {
		return "Employee service down.Please try again after some time...";
	}

}
