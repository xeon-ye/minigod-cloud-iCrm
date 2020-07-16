package com.sunline.config;

import com.sunline.modules.common.utils.ShiroUtils;
import com.sunline.modules.sys.entity.UserEntity;
import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @description: 判断是否登录的过滤器，被Shiro组件调用使用
 * @author: Larry Lai
 * @date: 2019/8/21 15:56
 * @version: v1.0
 */

public class ShiroLoginFilter extends AdviceFilter {
    /**
     * 在访问controller前判断是否登录，返回json，不进行重定向。
     *
     * @param request
     * @param response
     * @return true-通过验证，false-验证失败
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        UserEntity user = ShiroUtils.getUserEntity();

        httpServletRequest.getSession().setMaxInactiveInterval(36000);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        PrintWriter printWriter = null;
        if (null == user) {
            try {
                printWriter = response.getWriter();
                printWriter.write("{\"errorCode\": \"未登录\"}");
                printWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (printWriter != null) {
                    printWriter.close();
                }
            }
            return false;
        }
        return true;
    }
}
