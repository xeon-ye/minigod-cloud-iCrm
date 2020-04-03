//package com.minigod.securities.filter;
//
//import com.aliyun.oss.HttpMethod;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author kk
// */
//@Slf4j
//public class ReplaceStreamFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) {
//        log.info("StreamFilter初始化...");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
////
////        if (request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
////            filterChain.doFilter(request, response);
////            return;
////        }
//
//        request.getSession();
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        httpResponse.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        httpResponse.setHeader("Access-Control-Allow-Methods", "*");
//        httpResponse.setHeader("Access-Control-Max-Age", "3600");
//        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie, X-Accept-Token, X-Accept-Language");
//        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpResponse.setHeader("Content-type", "application/json");
//        httpResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
//
//        BaseRequestWrapper requestWrapper = new BaseRequestWrapper(request);
//
//
//        filterChain.doFilter(requestWrapper, response);
//    }
//
//    @Override
//    public void destroy() {
//        log.info("StreamFilter销毁...");
//    }
//}