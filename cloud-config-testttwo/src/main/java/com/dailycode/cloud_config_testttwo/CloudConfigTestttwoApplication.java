package com.dailycode.cloud_config_testttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigTestttwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigTestttwoApplication.class, args);
	}

}
