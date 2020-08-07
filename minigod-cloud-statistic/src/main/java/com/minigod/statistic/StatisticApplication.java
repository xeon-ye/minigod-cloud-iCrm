package com.minigod.statistic;

import com.minigod.common.holder.SpringContextHolder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@SpringBootApplication(scanBasePackages = "com.minigod")
@MapperScan(basePackages = "com.minigod.persist.*.mapper")
public class StatisticApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticApplication.class, args);
    }
    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}

