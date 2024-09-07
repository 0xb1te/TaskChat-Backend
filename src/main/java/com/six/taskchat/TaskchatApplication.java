package com.six.taskchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = { "com.six.taskchat" })
public class TaskchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskchatApplication.class, args);
	}
}
