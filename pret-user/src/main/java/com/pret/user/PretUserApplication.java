package com.pret.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCircuitBreaker
@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
@EnableTransactionManagement
public class PretUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(PretUserApplication.class, args);
	}

}
