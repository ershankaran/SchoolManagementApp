package com.shankar.schoolmanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.shankar.schoolmanagementapp","com.shankar.utils"})
public class SchoolmanagementappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmanagementappApplication.class, args);
	}

}
