package com.minigod.notify;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.minigod")
@MapperScan(basePackages = "com.minigod.persist.*.mapper")
@EnableDiscoveryClient
public class ServiceNotifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceNotifyApplication.class, args);
    }
}

