package com.sunline.component.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @description: 系统上下文初始化监听类
 * @author: Larry Lai
 * @date: 2018/8/16 10:36
 * @version: v1.0
 */
@WebListener
public class ContextWebListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(ContextWebListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        servletContextEvent.getServletContext().setAttribute("lang", "zh");

        String webRoot = servletContextEvent.getServletContext().getContextPath();
        logger.info("加载Servlet...");
        // Web根目录
        servletContextEvent.getServletContext().setAttribute("webRoot", webRoot);
        logger.info("Web根目录：" + servletContextEvent.getServletContext().getAttribute("webRoot"));
        // 资态资源根目录
        servletContextEvent.getServletContext().setAttribute("resRoot", webRoot + "/statics");
        logger.info("资态资源根目录：" + servletContextEvent.getServletContext().getAttribute("resRoot"));
    }
}  