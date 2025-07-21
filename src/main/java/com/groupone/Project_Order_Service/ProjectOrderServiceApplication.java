package com.groupone.Project_Order_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProjectOrderServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectOrderServiceApplication.class, args);
	}
}
