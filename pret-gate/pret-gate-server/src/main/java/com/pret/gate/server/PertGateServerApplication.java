package com.pret.gate.server;

import com.pret.gate.ratelimit.EnablePertGateRateLimit;
import com.pret.gate.ratelimit.config.IUserPrincipal;
import com.pret.gate.server.filter.UserPrincipal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@EnableDiscoveryClient
@EnableZuulProxy
@EnableScheduling
@EnablePertGateRateLimit
public class PertGateServerApplication {

    public static void main(String[] args) {
       // DBLog.getInstance().start();
        SpringApplication.run(PertGateServerApplication.class, args);
    }

    @Bean
    @Primary
    IUserPrincipal userPrincipal() {
        return new UserPrincipal();
    }
}