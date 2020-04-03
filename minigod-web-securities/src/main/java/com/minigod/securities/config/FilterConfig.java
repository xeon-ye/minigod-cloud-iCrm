package com.minigod.securities.config;

import com.minigod.securities.filter.WebFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author kk
 */
@Configuration
public class FilterConfig {
    /**
     * 注册过滤器
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authFilter());
        registration.addUrlPatterns("/*");
        registration.setName("authFilter");
        return registration;
    }

    /**
     * 实例化StreamFilter
     *
     * @return Filter
     */
    @Bean(name = "authFilter")
    public Filter authFilter() {
        return new WebFilter();
    }
}