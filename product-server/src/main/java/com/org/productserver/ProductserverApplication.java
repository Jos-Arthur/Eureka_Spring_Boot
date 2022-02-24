package com.org.productserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jos-arthur
 */
@SpringBootApplication
@EnableEurekaClient
public class ProductserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductserverApplication.class, args);
	}

}
