package com.pret;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCircuitBreaker
@SpringBootApplication()
@EnableScheduling
@EntityScan("com.pret.entity")
@EnableFeignClients
@EnableDiscoveryClient
@EnableJpaRepositories(value = "com.pret.repository")
@EnableTransactionManagement
public class PretOpenApplication {
    public static void main(String[] args) {
        SpringApplication.run(PretOpenApplication.class, args);
    }
}
