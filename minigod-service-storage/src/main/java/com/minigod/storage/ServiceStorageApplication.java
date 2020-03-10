package com.minigod.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = {"com.minigod.common", "com.minigod.storage"})
@EnableDiscoveryClient
@MapperScan(basePackages = "com.minigod.storage.mapper")
public class ServiceStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceStorageApplication.class, args);
    }
}

