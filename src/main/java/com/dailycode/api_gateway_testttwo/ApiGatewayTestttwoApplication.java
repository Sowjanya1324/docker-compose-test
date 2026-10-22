package com.dailycode.api_gateway_testttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayTestttwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayTestttwoApplication.class, args);
	}

}
