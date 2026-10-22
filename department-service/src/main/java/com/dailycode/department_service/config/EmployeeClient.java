package com.dailycode.department_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.reactive.function.client.WebClient;

import com.dailycode.department_service.controller.dto.Employee;

@Configuration
public class EmployeeClient {
	
	@Bean
	public WebClient getWebClient() {
		return WebClient.builder()
		.baseUrl("http://employee-service:8082/api/employee")
		.build();
	}
	
	@KafkaListener(topics = "employee-topic")
	public void getEmpEvent(Employee emp) {
		System.out.println("Emp: "+emp);
	}

}
