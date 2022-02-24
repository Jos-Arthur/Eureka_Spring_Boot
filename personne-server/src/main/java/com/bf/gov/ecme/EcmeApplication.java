package com.bf.gov.ecme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jos-arthur
 */
@SpringBootApplication
@EnableEurekaClient
public class EcmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcmeApplication.class, args);
	}

}
