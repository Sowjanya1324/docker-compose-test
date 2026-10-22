package com.dailycode.service_registry_testttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryTestttwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryTestttwoApplication.class, args);
	}

}
