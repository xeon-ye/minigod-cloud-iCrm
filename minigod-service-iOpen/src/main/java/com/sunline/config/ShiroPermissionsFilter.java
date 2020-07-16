package com.sunline.config;

import com.sunline.modules.common.utils.ShiroUtils;
import com.sunline.modules.sys.entity.UserEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 登录超时限制跳转
 * @author: Larry Lai
 * @date: 2019/8/21 15:43
 * @version: v1.0
 */

public class ShiroPermissionsFilter extends AdviceFilter {

    private static final Logger logger = LoggerFactory.getLogger(ShiroPermissionsFilter.class);

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        UserEntity user = ShiroUtils.getUserEntity();
        String url = httpServletRequest.getRequestURI();

        if (null == user && !"/".equals(url)) {
            String requestedWith = httpServletRequest.getHeader("X-Requested-With");
            // 如果是ajax返回指定数据
            if (StringUtils.isNotEmpty(requestedWith) && StringUtils.equals(requestedWith, "XMLHttpRequest")) {
                // 重定向
                String path = httpServletRequest.getContextPath();
                String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
                // ajax请求
                httpServletResponse.setHeader("sessionstatus", "TIMEOUT");
                httpServletResponse.setHeader("content_path", basePath + "login");
                // 403 禁止
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return false;
            } else {
                // 不是ajax进行重定向处理
                logger.info(url + "重定向到了登录界面");
                httpServletResponse.sendRedirect("/login");
                return false;
            }
        }
        return true;
    }
}
