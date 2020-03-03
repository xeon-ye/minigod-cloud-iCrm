package com.minigod.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@SpringBootApplication(scanBasePackages = {"com.minigod.common", "com.minigod.notify", "com.minigod.storage", "com.minigod.security"})
@EnableDiscoveryClient
@MapperScan("com.minigod.*.mapper")
@ServletComponentScan
@EnableWebMvc
public class SecurityWebServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SecurityWebServiceApplication.class, args);
        System.out.println(context);
    }

}
