package com.sunline.modules.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 该作用域仅适用于ApplicationContext环境
 */
public class SessionUtils {
    static String h5SessionKey = "H5_SESSION_USER_ID";

    public static HttpServletRequest getHttpServletRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
    /**
     * 获取当前请求session
     * @return HttpSession
     */
    public static HttpSession getHttpSession(){
        return getHttpServletRequest().getSession();
    }
}
