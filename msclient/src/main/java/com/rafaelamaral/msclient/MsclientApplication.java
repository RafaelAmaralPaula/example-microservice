package com.rafaelamaral.msclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsclientApplication.class, args);
	}

}
