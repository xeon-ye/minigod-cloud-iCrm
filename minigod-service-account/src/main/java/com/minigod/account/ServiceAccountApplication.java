package com.minigod.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = {"com.minigod.common", "com.minigod.protocol", "com.minigod.notify", "com.minigod.storage", "com.minigod.account"})
@EnableDiscoveryClient
@MapperScan(basePackages = "com.minigod.*.mapper")
public class ServiceAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAccountApplication.class, args);
    }
}

