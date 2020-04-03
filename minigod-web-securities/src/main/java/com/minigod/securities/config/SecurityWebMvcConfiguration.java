package com.minigod.securities.config;

import com.minigod.securities.annotation.support.LoginUserHandlerMethodArgumentResolver;
//import com.minigod.securities.interceptor.ProxySignInterceptor;
import com.minigod.securities.interceptor.WebSignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class SecurityWebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")// 允许跨域访问的路径
                .allowedOrigins("*")// 允许跨域访问的源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")// 允许请求方法
                .maxAge(168000)// 预检间隔时间
                .allowedHeaders("*")// 允许头部设置
                .allowCredentials(true);// 是否发送cookie
    }

    @Bean
    public  LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver(){
        return  new LoginUserHandlerMethodArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserHandlerMethodArgumentResolver());
    }

//    @Bean
//    public ProxySignInterceptor proxySignInterceptor(){
//        return  new ProxySignInterceptor();
//    }
//   @Bean
//    public WebSignInterceptor webSignInterceptor(){
//        return  new WebSignInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(proxySignInterceptor()).addPathPatterns("/proxy/**");
//        registry.addInterceptor(webSignInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
}
