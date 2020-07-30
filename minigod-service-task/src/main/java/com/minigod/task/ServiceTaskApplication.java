package com.minigod.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 描述:
 * 创建时间: 2019-08-03
 *
 * @author kk
 * @version v1.0
 */
@Configuration
@SpringBootApplication(scanBasePackages = "com.minigod")
@MapperScan(basePackages = "com.minigod.persist.*.mapper")
public class ServiceTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceTaskApplication.class, args);
    }
}
