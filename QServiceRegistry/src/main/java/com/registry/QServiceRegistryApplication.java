package com.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class QServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QServiceRegistryApplication.class, args);
	}

}
